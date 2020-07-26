#Stopping there
#Does not send message but does login, open compose and fill target


from selenium import webdriver
import time

subject="Just testing"
message="This is an automated email"
username=input("Enter your username:")
password=input("Enter your password: ")
target=input("Enter target e-mail:")

browser=webdriver.Firefox()
browser.get('https://passport.yandex.com/auth?from=mail&origin=hostroot_homer_auth_com&retpath=https%3A%2F%2Fmail.yandex.com%2F&backpath=https%3A%2F%2Fmail.yandex.com%3Fnoretpath%3D1')
time.sleep(1)
userField=browser.find_element_by_id('passp-field-login')
userField.send_keys(username)
userField.submit()
time.sleep(1)
passField=browser.find_element_by_id('passp-field-passwd')
passField.send_keys(password)
passField.submit()
time.sleep(1)
browser.get('https://mail.yandex.com/#compose')

time.sleep(10)
target_box=browser.find_element_by_class_name('composeYabbles')
target_box.send_keys(target)
content_box=browser.find_element_by_class_name('cke_contents_ltr')
content_box.send_keys(message)
subject_box=browser.find_element_by_css_selector('input[name="subject"]')
subject_box.send_keys(subject)


time.sleep(3)
content_box.submit()

