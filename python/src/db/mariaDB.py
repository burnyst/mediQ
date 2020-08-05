import pymysql


class MariaDB:
    def __init__(self, host="localhost", user="root", password="1234", db="pythondb", charset="utf8"):
        self.host = host
        self.user = user
        self.password = password
        self.db = db
        self.charset = charset
        self.con = None

    def connect(self):
        self.con = pymysql.connect(self.host, self.user, self.password, self.db, self.charset)

    def disconnect(self):
        self.con.close()

    def commit(self):
        self.con.commit()

    def rollback(self):
        self.con.rollback()

    def execute(self, sql, args=None):
        # cur = con.cursor()
        cur = self.con.cursor(pymysql.cursors.DictCursor)
        cur.execute(sql, args)
        rst = cur.fetchall()
        return rst

    def execute_dml(self, sql, args=None):
        cur = self.con.cursor()
        rst = cur.execute(sql, args)
        return rst
