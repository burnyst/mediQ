import requests
from bs4 import BeautifulSoup


def http_get(url):
    rcv = requests.get(url)
    rcv_code = rcv.status_code
    if rcv_code == 200:
        return rcv.text
    else:
        print("http_request Error\n", "code:" + rcv_code)
        return None


class OpenDataPortal(object):
    def __init__(self, id, service, method, query):
        url = "http://apis.data.go.kr/"+id+"/"+service+"/"+method+"?"+query
        self.resultCode = None
        self.body = None
        self.response = http_get(url)
        # print(self.response)
        if self.response is not None:
            bs = BeautifulSoup(self.response, "xml")
            try:
                self.resultCode = bs.response.header.resultCode.text
                self.body = bs.response.body
            except:
                print("http_get error")
                print(self.response)
