#! python3
# quickWeather.py - Prints the weather for a location from the command line.

import json,requests,sys

#Compute location from command line arguments.
if len(sys.argv)<2:
    print('Usage: quickWeather.py location')
    sys.exit()
location=' '.join(sys.argv[1:])

#Download JSON  data from OpenWeatherMap.org's API
url ='http://api.openweathermap.org/data/2.5/forecast/daily?q={}&cnt=3'.format(location)
response=requests.get(url)
response.raise_for_status()
print(response.text)
#Load JSON data into Python variable