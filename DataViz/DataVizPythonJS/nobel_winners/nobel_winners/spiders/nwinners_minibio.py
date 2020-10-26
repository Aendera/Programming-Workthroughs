import scrapy
import re
BASE_URL="http://en.wikipedia.org"
def process_winner_li(w,country=None):
    wdata={}
    wdata['link']=BASE_URL+w.xpath('a/@href').extract()[0]
    text=' '.join(w.xpath('descendant-or-self::text()').extract())
    wdata['name']=text.split(',')[0].strip()
    year=re.findall('\d{4}',text)
    if year:
        wdata['year'] =year[0]
    else:
        wdata['year']=0
        print('OOps, no year in ', text)
    category=re.findall('Physics|Chemistry|Physiology or Medicine|Literature|Peace|Economics',text)
    if category:
        wdata['category']=category[0]
    else:
        wdata['category']=''
        print('Oops,no category in ',text)
    if country:
        if text.find('*')!=-1:
            wdata['country']=''
            wdata['born_in']=country
        else:
            wdata['country']=country
            wdata['born_in']=''
    wdata['text']=text
    return wdata
        
class NWinnerItem(scrapy.Item):
    name=scrapy.Field()
    link=scrapy.Field()
    link_text=scrapy.Field()
    mini_bio=scrapy.Field()
    image_urls=scrapy.Field()
    bio_image=scrapy.Field()
    images=scrapy.Field()
class NWinnerSpiderBio(scrapy.Spider):
    
    name='nwinners_minibio'
    allowed_domains=['en.wikipedia.org']
    start_urls=['https://en.wikipedia.org/wiki/List_of_Nobel_laureates_by_country']
    
    def parse(self,response):
        #print(response.url)
        filename=response.url.split('/')[-1]
        h3s=response.xpath('//h3')
        for h3 in list(h3s)[:2]:
            country=h3.xpath('span[@class="mw-headline"]/text()').extract()
            if country:
                winners=h3.xpath('following-sibling::ol[1]')
                for w in winners.xpath('li'):
                    wdata={}
                    wdata['link']=BASE_URL+w.xpath('a/@href').extract()[0]
                    
                    request=scrapy.Request(wdata['link'],callback=self.get_mini_bio)
                    request.meta['item']=NWinnerItem(**wdata)
                    yield request
                    
                    
    def get_mini_bio(self,response):
        BASE_URL_ESCAPED='http:\/\/en.wikipedia.org'
        item=response.meta['item']
        item['image_urls']=[]
        img_src=response.xpath('//table[contains(@class,"infobox")]//img/@src')
        if img_src:
            print(img_src[0].extract())
            item['image_urls']=['https:'+img_src[0].extract()]
        mini_bio=''
        paras=response.xpath('//*[@id="mw-content-text"]/div[1]/p/text()').extract()
        #paras=response.xpath('//*[@id="mw-content-text"]/p[text() or normalize-space(.)=""]').extract()
        for p in paras:
            if p=="<p></p>":
                break
            mini_bio+=p
        
        mini_bio=mini_bio.replace('href="/wiki','href="'+BASE_URL+'/wiki')
        mini_bio=mini_bio.replace('href="#',item['link']+'#')
        item['mini_bio']=mini_bio
        yield item