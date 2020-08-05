from src.dao.medicineProductDao import MedicineProductItemDao
from src.db.oracleDB import OracleDB


class MedicineProductItem:
    def __init__(self):
        self.dao = MedicineProductItemDao()

    def get(self, page_no, count):
        db = OracleDB(host="192.168.56.67", user="mediq", password="mediq")
        db.connect()
        num_of_rows = 1
        for i in range(page_no, page_no+count, 1):
            if i+num_of_rows > page_no+count:
                num_of_rows = page_no+count-i
            items = self.dao.select(i, num_of_rows)
            if len(items) > 0:
                self.dao.insert(db, items)
            else:
                break
        db.commit()
        db.disconnect()


if __name__ == "__main__":
    product = MedicineProductItem()
    # product.get(1, 10000)
    product.get(25001, 2000)
