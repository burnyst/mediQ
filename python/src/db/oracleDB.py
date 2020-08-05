import cx_Oracle
import os


def output_type_handler(cursor, name, defaultType, size, precision, scale):
    if defaultType == cx_Oracle.CLOB:
        return cursor.var(cx_Oracle.LONG_STRING, arraysize=cursor.arraysize)
    if defaultType == cx_Oracle.BLOB:
        return cursor.var(cx_Oracle.LONG_BINARY, arraysize=cursor.arraysize)


class OracleDB:
    def __init__(self, host="localhost", port="1521", user="system", password="1234", db="orcl"):
        self.host = host
        self.port = port
        self.user = user
        self.password = password
        self.db = db
        self.con = None

    def connect(self):
        os.environ['NLS_LANG'] = '.UTF8'
        self.con = cx_Oracle.connect(self.user+"/"+self.password+"@"+self.host+":"+self.port+"/"+self.db)
        self.con.outputtypehandler = output_type_handler

    def disconnect(self):
        self.con.close()

    def commit(self):
        self.con.commit()

    def rollback(self):
        self.con.rollback()

    def execute(self, sql, **args):
        cur = self.con.cursor()
        cur.execute(sql, args)
        rst = cur
        return rst

    def execute_dml(self, sql, **args):
        cur = self.con.cursor()
        # cur.setinputsizes(template=cx_Oracle.CLOB)
        rst = cur.execute(sql, args)
        return rst


if __name__ == "__main__":
    db = OracleDB(user="scott", password="tiger")
    db.connect()
    # emps = db.execute("select * from emp")
    emps = db.execute("select * from emp where ename=:ename and empno=:empno", ename="KING", empno="7839")
    for i in emps:
        print(i)
