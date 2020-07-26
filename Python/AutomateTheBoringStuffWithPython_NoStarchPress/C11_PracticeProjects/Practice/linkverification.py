import webbrowser,requests,os,bs4


os.makedirs(os.path.join(os.getcwd(),'verifiedlinks'),exist_ok=True)
startpage="https://inventwithpython.com"
#get links
res=requests.get(startpage)
res.raise_for_status()
soup=bs4.BeautifulSoup(res.text)
links=[]
for link in soup.findAll('a'):
    if not link.get('href'):
        links.append(startpage)
    elif link.get('href').startswith('http'):
        links.append(link.get('href'))
    else:
        links.append(startpage+str(link.get('href')))
print(links)

#run through links
i=0
for link in links:
    title="saved_page{}.html".format(i)
    i+=1
    #try to access link
    print(link)
    res=requests.get(link)
    print(res.status_code)
    #print error if needed
    if res.status_code>300:
        print("Error")
        print("Code: {}".format(res.status_code))
        print("Broken link: {}".format(link))
    #else save in folder
    else:
        file=open(os.path.join(os.getcwd(),'verifiedlinks',title),'wb')
        for chunk in res.iter_content(100000):
            file.write(chunk)
        file.close()