from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
browser=webdriver.Firefox()
browser.get('https://gabrielecirulli.github.io/2048/')
html=browser.find_element_by_tag_name('html')
game_over=None
while not game_over:
    try:
        game_over=browser.find_element_by_class_name('game-over')
    except:
        html.send_keys(Keys.UP)
        html.send_keys(Keys.RIGHT)
        html.send_keys(Keys.DOWN)
        html.send_keys(Keys.LEFT)
        time.sleep(1)


time.sleep(3)
browser.close()