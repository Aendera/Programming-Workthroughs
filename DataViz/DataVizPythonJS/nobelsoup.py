from bs4 import BeautifulSoup
import requests

BASE_URL='http://en.wikipedia.org'

HEADERS={'USER-Agent':'Mozilla/5.0'}

def get_Nobel_soup():
    """Return parsed tag tree of Nobel prize page"""
    response=requests.get(BASE_URL+'/wiki/List_of_Nobel_laureates',
                          headers=HEADERS)
    return BeautifulSoup(response.content,'lxml')


def get_column_titles(table):
    cols=[]
    for th in table.select_one('tr').select('th')[1:]:
        link=th.select_one('a')
        if link:
            cols.append({'name':link.text,
                        'href':link.attrs['href']})
        else:
                cols.append({'name':th.text,'href':None})
    return cols

def get_Nobel_winners(table):
    cols=get_column_titles(table)
    winners=[]
    for row in table.select('tr')[1:-1]:
        year=row.select_one('td').text
        for i,td in enumerate(row.select('td')[1:]):
            for winner in td.select('a'):
                href=winner.attrs['href']
                if not href.startswith('#endnote'):
                    winners.append({
                        'year':year,
                        'category':cols[i]['name'],
                        'name':winner.text,
                        'link':winner.attrs['href']
                    })
    return winners

def get_winner_nationality(w):
    """Scrape biographic data from winner's wikipedia page"""
    data=requests.get('http://en.wikipedia.org'+w['link']).text
    soup=BeautifulSoup(data)
    person_data={'name':w['name']}
    attr_rows=soup.select('table.infobox tr')
    for tr in attr_rows:
        try:
            attribute=tr.select_one('th').text
            if attribute == "Nationality":
                person_data[attribute]=tr.select_one('td').text
        except AttributeError:
                pass


    return person_data