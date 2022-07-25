from selenium import webdriver
import pandas as pd
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

driver = webdriver.Chrome()
driver.get("https://datatables.net/")
driver.maximize_window()

drpdown = Select(driver.find_element(By.XPATH, "//select[@name='example_length']"))
drpdown.select_by_visible_text("25")
data = driver.find_elements(By.XPATH, "//table[@id='example']/tbody/tr/td")

for i in data:
    print(i.text, end="")
    print()

data1 = driver.find_elements(By.XPATH, "//table[@id='example']/thead/tr/th")

for i in data1:
    if i.text == "Age":
        i.click()


driver.close()