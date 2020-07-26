
import os,requests,bs4
#Needs refining, currently takes all imgs, not just search images
new_folder=os.path.join(os.getcwd(),'imagestorage')
os.makedirs(new_folder,exist_ok=True)
site="https://unsplash.com/s/photos/"
search_term="galaxy"

search=site+search_term

res=requests.get(search)
soup=bs4.BeautifulSoup(res.text,features="lxml")
#print(res.text)
allimg=soup.findAll("img")
#print(allimg)
#imgtags=soup.findAll('figure img')
#print(imgtags)
i=0
for img in allimg:
    imgUrl=img.get('src')
    res=requests.get(imgUrl)
    imgFile=open(os.path.join(new_folder,search_term+str(i)+".jpg"),'wb')
    for chunk in res.iter_content(100000):
        imgFile.write(chunk)
    imgFile.close()
    i+=1