import requests
#response=requests.get(\
#    "https://en.wikipedia.org/wiki/Nobel_prize")

REST_EU_ROOT_URL="http://restcountries.eu/rest/v1"

def REST_country_request(field="all",name=None,params=None):
    headers={'User-Agent':'Mozilla/5.0'}
    if not params:
        params={}
    if field=='all':
        return requests.get(REST_EU_ROOT_URL+'/all')

    url="{0}/{1}/{2}".format(REST_EU_ROOT_URL,field,name)
    print('Requesting url:',url)
    response=requests.get(url,params=params,headers=headers)
    if not response.status_code==200:
        raise Exception('Request failed with status code '+str(response.status_code))
    return response


