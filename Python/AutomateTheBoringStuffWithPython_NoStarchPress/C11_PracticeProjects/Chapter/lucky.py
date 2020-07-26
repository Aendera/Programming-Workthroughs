#! python3
# lucky.py - Opens several Google search results.
#Does not work as google now rendering responses via javacript
#should work for other sites
#As suggested on subreddit, using pypi module search instead
import requests,sys,webbrowser,bs4

print('Searching Pypi...') #display text while downloading
#res=requests.get('http://google.com/search?q='+ ' '.join(sys.argv[1:]))
res=requests.get('http://pypi.org/search/?q='+' '.join(sys.argv[1:]))
res.raise_for_status()

#TODO: Retrieve top search result links
soup=bs4.BeautifulSoup(res.text)
#TODO: Open browser tab for each result
#linkElems=soup.select('.r a')
linkElems=soup.select('.package-snippet')
#print(linkElems)
numOpen=min(5,len(linkElems))

print(numOpen)
for i in range(numOpen):
    #webbrowser.open('http://google.com'+linkElems[i].get('href'))
    webbrowser.open('http://pypi.org/'+linkElems[i].get('href'))