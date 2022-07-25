import requests
import pandas as pd

cookies = {
    'isBrowserFP': 'true',
    'GEOLS': 'MH',
    'GEOLC': 'Navi%20Mumbai',
    'GEOLCO': 'IN',
    'bft': '1',
    'jfpj': '8755b6ea8482b2e9ef47a0dcc194b3f8',
    '_gcl_au': '1.1.105852055.1658516161',
    '_gid': 'GA1.2.933506138.1658516161',
    '_ga': 'GA1.2.1243362608.1658516161',
    'gClId': '1243362608.1658516161',
    'destCountry': 'IND',
    'srcCountry': 'IND',
    'PrimoDetails': '%7B%22lastUpdated%22%3A%222022-07-23%22%2C%22lastShown%22%3A%222022-07-23%22%7D',
    'singleSeatCoachMark': '2',
    'country': 'IND',
    'currency': 'INR',
    'selectedCurrency': 'INR',
    'language': 'en',
    'defaultlanguage': 'en',
    'lzFlag': '0',
    'bCore': '1',
    'defaultCountry': 'IND',
    'deviceSessionId': 'bf90b792-0aef-4b01-ac35-5549f5a671e6',
    'bm_mi': '5C1989E5907DD31941FB12BB41E157B7~YAAQ5/3UFwYJaLuBAQAAhVL6KRD1hSDVNNh6hoMcVLhq7uTWh0sbOndl9DJn1BrLi0covt5pP11xmwm5IpFmnGB3rFDm+zmzDHh8leja+6sVYO5yj4no+BP/W7qmeIh2aVT5OBE8vLFVjSFgnJzTfbAM39TSJ5xOrsh+bIPDRus6cMcjoRhaFhvMHOWyjqO8gMijv4rgJZ32L1RVSjJWc3e+emZjYHP3WCZc06dSudXhN8XbshPGRwRnfwn6v3bvxeAXjLSxCCMOzca1aQVACf/aC3VJ16VrvU1w6WDXAA5uuQMvX7j3fThgab3m~1',
    'tvc_smc_bus': 'google / organic / (not set)',
    'tvc_session_alive_bus': '1',
    'ak_bmsc': '75D680ED66692700D3CDBCDDB3794BCD~000000000000000000000000000000~YAAQtEU5F/284bWBAQAAB1n6KRBYuO6fYeMPx/ziW3g2GWYhz2SLQkqF/m2PycT7uaWdmQHXWCuJpJ+dIiw6KtpB6pDOaizNIcXr54gVvgEiE59MbtD1VRbbs8HzpsPvdFZnCt6FvYzTz01YzM+DYEjk2Apkr71C8o0Xi/sWSZRSMOqflpaZp4ZRM4dGlRQ40/NR1kZSncs6D2u2sBQEyeO+wLAhKlXAePPYADVl4warADETWBrLyarDkISBJIFtfyPwBynIEIMeSWOs5CNfKD6exz3+pnTGkFosG6mpfisnLFrI50UiUQgQfuB/ReVYFZSZ8W7XFlMuhHVHU4IU+SvYDZg5ebeI+Coq7ESfsSRwjTaW+UqeOiBMEKHnO06j1IuwFQoiJEtie0i7fV7EXMWtQkJhoFoykRy4cO88AztWa3RcEnyecp+Cbvt5k2cJkYX+sFIB+lxJZI/jWSjx3O4nccyeo6D4Nb/3QuhGAUiF5+1smanD4ENBo6AbXfzkBA==',
    'Branch_BrowserFingerPrintID': '794548284069261784',
    'mriClientId': 'ccbff0f0-8d65-4713-b291-15f853403d6a-owLzq2ddJdjjZtQM%2FpMVeQ%3D%3D',
    'tvc_user_type': 'old',
    'mriClientIdSetDate': '7%2F23%2F22%209%3A13%3A17%20AM',
    'mriSessionId': '2c17561e-e487-4ddb-a338-bacb4f0b5ff9-Zc9U9x6l1NUlGUBotpCf-v0i9mY=',
    'bm_sv': '454082ABA8D2D99D1E34D68AA65AC9EB~YAAQtEU5F85V47WBAQAAex9XKhChMF5exW4CwlRVtaLYCrV1id8LotIEujfS5NGozYu1ACiNVo3ljUXgFRgQWgn63GJ0g0f8bvT9KR3nP+M6qTRrS3vv26l7vbEQDpdauDm4G4VtTE4JA0HuYmNPixb8ltGmd2bdb7p0DNqnRqhnqNZFVW4QEOn5v+y93h73oGj260q3KSv3z3Vn9vqNoP4QOK++zPlB1IhMb/h1P9DLsWFKNM5REmwxdBMtxhF8~1',
}

headers = {
    'authority': 'www.redbus.in',
    'accept': 'application/json, text/plain, */*',
    'accept-language': 'en-US,en;q=0.9,la;q=0.8',
    # 'content-length': '0',
    'content-type': 'application/json',
    # Requests sorts cookies= alphabetically
    # 'cookie': 'isBrowserFP=true; GEOLS=MH; GEOLC=Navi%20Mumbai; GEOLCO=IN; bft=1; jfpj=8755b6ea8482b2e9ef47a0dcc194b3f8; _gcl_au=1.1.105852055.1658516161; _gid=GA1.2.933506138.1658516161; _ga=GA1.2.1243362608.1658516161; gClId=1243362608.1658516161; destCountry=IND; srcCountry=IND; PrimoDetails=%7B%22lastUpdated%22%3A%222022-07-23%22%2C%22lastShown%22%3A%222022-07-23%22%7D; singleSeatCoachMark=2; country=IND; currency=INR; selectedCurrency=INR; language=en; defaultlanguage=en; lzFlag=0; bCore=1; defaultCountry=IND; deviceSessionId=bf90b792-0aef-4b01-ac35-5549f5a671e6; bm_mi=5C1989E5907DD31941FB12BB41E157B7~YAAQ5/3UFwYJaLuBAQAAhVL6KRD1hSDVNNh6hoMcVLhq7uTWh0sbOndl9DJn1BrLi0covt5pP11xmwm5IpFmnGB3rFDm+zmzDHh8leja+6sVYO5yj4no+BP/W7qmeIh2aVT5OBE8vLFVjSFgnJzTfbAM39TSJ5xOrsh+bIPDRus6cMcjoRhaFhvMHOWyjqO8gMijv4rgJZ32L1RVSjJWc3e+emZjYHP3WCZc06dSudXhN8XbshPGRwRnfwn6v3bvxeAXjLSxCCMOzca1aQVACf/aC3VJ16VrvU1w6WDXAA5uuQMvX7j3fThgab3m~1; tvc_smc_bus=google / organic / (not set); tvc_session_alive_bus=1; ak_bmsc=75D680ED66692700D3CDBCDDB3794BCD~000000000000000000000000000000~YAAQtEU5F/284bWBAQAAB1n6KRBYuO6fYeMPx/ziW3g2GWYhz2SLQkqF/m2PycT7uaWdmQHXWCuJpJ+dIiw6KtpB6pDOaizNIcXr54gVvgEiE59MbtD1VRbbs8HzpsPvdFZnCt6FvYzTz01YzM+DYEjk2Apkr71C8o0Xi/sWSZRSMOqflpaZp4ZRM4dGlRQ40/NR1kZSncs6D2u2sBQEyeO+wLAhKlXAePPYADVl4warADETWBrLyarDkISBJIFtfyPwBynIEIMeSWOs5CNfKD6exz3+pnTGkFosG6mpfisnLFrI50UiUQgQfuB/ReVYFZSZ8W7XFlMuhHVHU4IU+SvYDZg5ebeI+Coq7ESfsSRwjTaW+UqeOiBMEKHnO06j1IuwFQoiJEtie0i7fV7EXMWtQkJhoFoykRy4cO88AztWa3RcEnyecp+Cbvt5k2cJkYX+sFIB+lxJZI/jWSjx3O4nccyeo6D4Nb/3QuhGAUiF5+1smanD4ENBo6AbXfzkBA==; Branch_BrowserFingerPrintID=794548284069261784; mriClientId=ccbff0f0-8d65-4713-b291-15f853403d6a-owLzq2ddJdjjZtQM%2FpMVeQ%3D%3D; tvc_user_type=old; mriClientIdSetDate=7%2F23%2F22%209%3A13%3A17%20AM; mriSessionId=2c17561e-e487-4ddb-a338-bacb4f0b5ff9-Zc9U9x6l1NUlGUBotpCf-v0i9mY=; bm_sv=454082ABA8D2D99D1E34D68AA65AC9EB~YAAQtEU5F85V47WBAQAAex9XKhChMF5exW4CwlRVtaLYCrV1id8LotIEujfS5NGozYu1ACiNVo3ljUXgFRgQWgn63GJ0g0f8bvT9KR3nP+M6qTRrS3vv26l7vbEQDpdauDm4G4VtTE4JA0HuYmNPixb8ltGmd2bdb7p0DNqnRqhnqNZFVW4QEOn5v+y93h73oGj260q3KSv3z3Vn9vqNoP4QOK++zPlB1IhMb/h1P9DLsWFKNM5REmwxdBMtxhF8~1',
    'origin': 'https://www.redbus.in',
    'referer': 'https://www.redbus.in/bus-tickets/mumbai-to-pune?fromCityName=Mumbai&fromCityId=462&toCityName=Pune&toCityId=130&onward=23-Jul-2022&srcCountry=IND&destCountry=IND&opId=0&busType=Any',
    'sec-ch-ua': '".Not/A)Brand";v="99", "Google Chrome";v="103", "Chromium";v="103"',
    'sec-ch-ua-mobile': '?0',
    'sec-ch-ua-platform': '"Windows"',
    'sec-fetch-dest': 'empty',
    'sec-fetch-mode': 'cors',
    'sec-fetch-site': 'same-origin',
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36',
}

params = {
    'fromCity': '462',
    'toCity': '130',
    'src': 'Mumbai',
    'dst': 'Pune',
    'DOJ': '23-Jul-2022',
    'sectionId': '0',
    'groupId': '0',
    'limit': '0',
    'offset': '0',
    'sort': '0',
    'sortOrder': '0',
    'meta': 'true',
    'returnSearch': '0',
}

response = requests.post('https://www.redbus.in/search/SearchResults', params=params, cookies=cookies, headers=headers)

print(response)
result_json = response.json()
print(result_json.keys())

totalCount = result_json['inv']
print(len(totalCount))

travel_namez = result_json['inv'][0]['Tvs']
print(travel_namez)

rating = result_json['inv'][0]['rt']['totRt']
print(rating)

seats = result_json['inv'][0]['rt']['ct']
print(seats)

date = result_json['inv'][0]['dt']
departuredates = date.split(" ")[0]
duration = date.split(" ")[1]
print(departuredates)
print(duration)

fare_start= result_json['inv'][0]['frLst'][0:]
print(fare_start[0])

arr_address = result_json['inv'][0]['dpData'][0]['Address']
print(arr_address)

arr_time= result_json['inv'][0]['dpData'][0]['BpTm']
print(arr_time)


traveller_name = []
rating = []
seats = []
departuredates = []
duration = []
fare_start= []
arr_address = []
arr_time = []


for result in totalCount:
    traveller_name.append(result['Tvs'])
    rating.append(result['rt']['totRt'])
    seats.append(result['rt']['ct'])
    departuredates.append(result['dt'][0:10])
    duration.append(result['dt'][11:])


target = pd.DataFrame({'traveller_name' : traveller_name,
                       'rating' : rating,
                       'seats' : seats,
                       'departuredates' : departuredates,
                       'duration' : duration})

print(target)
target.to_excel('Assignment5.xlsx', index=False)