from bs4 import BeautifulSoup
import urllib.request as req

# HTMLを取得
url = "http://code-search.uni.lu/facoy?q=public+int+addition%28int+...cost%29+%7B%0D%0A++++++++int+totalcost%3D+0%3B%0D%0A++++++++for%28+int+i%3D0%3B+i%3Ccost.length%3B+i%2B%2B+%29+%7B%0D%0A++++++++++++++++totalcost+%2B%3D+cost%5Bi%5D%3B%0D%0A++++++++%7D%0D%0A++++++++return+totalcost%3B%0D%0A++++%7D%0D%0A%0D%0A"
res = req.urlopen(url)

# HTMLを解析
soup = BeautifulSoup(res, "html.parser")

# 任意のデータを抽出 --- (※1)
f = open('test.txt','w')

src = soup.select("div#code_container > div.snippet_item > div.snippet_metadata > span > a")
for s in src:
    if ".java" in s.string:
        f.write(s.string)
        f.write("\n")
        print(s.string)