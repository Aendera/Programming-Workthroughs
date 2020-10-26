# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface
from itemadapter import ItemAdapter


class NobelWinnersPipeline:
    def process_item(self, item, spider):
        return item
from scrapy.exceptions import DropItem

class DropNonPersons(object):
    def process_item(self,item,spider):
        if not item['gender']:
            raise DropItem("No gender for {}".format(item['name']))
        return item
    
import scrapy
from scrapy.pipelines.images import ImagesPipeline

class NobelImagesPipeline(ImagesPipeline):
    def get_media_requests(self,item,info):
        for image_url in item['image_urls']:
            yield scrapy.Request(image_url)
    def item_completed(self,results,item,info):
        image_paths=[x['path'] for ok, x in results if ok]
        if image_paths:
            print(image_paths[0])
            item['bio_image']=image_paths[0]
        return item