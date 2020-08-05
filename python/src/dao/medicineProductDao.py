import cx_Oracle
from src.mfds.mfds import MedicineProductPermissionInfo


class MedicineProductItemDao:
    def __init__(self):
        self.open_data = MedicineProductPermissionInfo()

    def select(self, page_no=1, num_of_rows=10):
        return self.open_data.select_item(page_no, num_of_rows)

    def insert(self, db, items):
        for i in items:
            # sql_form = """merge into MdcinPrductItem using dual on (ITEM_SEQ = '{ITEM_SEQ}')
            #     when matched then update set
            #         ITEM_NAME='{ITEM_NAME}', ENTP_NAME='{ENTP_NAME}', ITEM_PERMIT_DATE='{ITEM_PERMIT_DATE}',
            #         NB_DOC_DATA='{NB_DOC_DATA}', CANCEL_DATE='{CANCEL_DATE}', EE_DOC_DATA='{EE_DOC_DATA}',
            #         ETC_OTC_CODE='{ETC_OTC_CODE}', UD_DOC_DATA='{UD_DOC_DATA}', CHANGE_DATE='{CHANGE_DATE}',
            #         CLASS_NO='{CLASS_NO}', CHART='{CHART}', PACK_UNIT='{PACK_UNIT}'
            #     when not matched then insert
            #         (ITEM_SEQ, ITEM_NAME, ENTP_NAME, ITEM_PERMIT_DATE, NB_DOC_DATA, CANCEL_DATE,
            #             EE_DOC_DATA, ETC_OTC_CODE, UD_DOC_DATA, CHANGE_DATE, CLASS_NO, CHART, PACK_UNIT)
            #         values ('{ITEM_SEQ}', '{ITEM_NAME}', '{ENTP_NAME}', '{ITEM_PERMIT_DATE}', '{NB_DOC_DATA}', '{CANCEL_DATE}',
            #             '{EE_DOC_DATA}', '{ETC_OTC_CODE}', '{UD_DOC_DATA}', '{CHANGE_DATE}', '{CLASS_NO}', '{CHART}', '{PACK_UNIT}')"""
            # sql = sql_form.format(ITEM_SEQ=i.ITEM_SEQ, ITEM_NAME=i.ITEM_NAME, ENTP_NAME=i.ENTP_NAME,
            #     ITEM_PERMIT_DATE=i.ITEM_PERMIT_DATE, NB_DOC_DATA=i.NB_DOC_DATA, CANCEL_DATE=i.CANCEL_DATE,
            #     EE_DOC_DATA=i.EE_DOC_DATA, ETC_OTC_CODE=i.ETC_OTC_CODE, UD_DOC_DATA=i.UD_DOC_DATA,
            #     CHANGE_DATE=i.CHANGE_DATE, CLASS_NO=i.CLASS_NO, CHART=i.CHART, PACK_UNIT=i.PACK_UNIT)
            # db.execute_dml(sql)
            # sql = """merge into MdcinPrductItem using dual on (ITEM_SEQ = :ITEM_SEQ)
            #     when matched then update set
            #         ITEM_NAME=:ITEM_NAME, ENTP_NAME=:ENTP_NAME, ITEM_PERMIT_DATE=:ITEM_PERMIT_DATE,
            #         NB_DOC_DATA=:NB_DOC_DATA, CANCEL_DATE=:CANCEL_DATE, EE_DOC_DATA=:EE_DOC_DATA,
            #         ETC_OTC_CODE=:ETC_OTC_CODE, UD_DOC_DATA=:UD_DOC_DATA, CHANGE_DATE=:CHANGE_DATE,
            #         CLASS_NO=:CLASS_NO, CHART=:CHART, PACK_UNIT=:PACK_UNIT
            #     when not matched then insert
            #         (ITEM_SEQ, ITEM_NAME, ENTP_NAME, ITEM_PERMIT_DATE, NB_DOC_DATA, CANCEL_DATE,
            #             EE_DOC_DATA, ETC_OTC_CODE, UD_DOC_DATA, CHANGE_DATE, CLASS_NO, CHART, PACK_UNIT)
            #         values (:ITEM_SEQ, :ITEM_NAME, :ENTP_NAME, :ITEM_PERMIT_DATE, :NB_DOC_DATA, :CANCEL_DATE,
            #             :EE_DOC_DATA, :ETC_OTC_CODE, :UD_DOC_DATA, :CHANGE_DATE, :CLASS_NO, :CHART, :PACK_UNIT)"""
            sql = """insert into MdcinPrductItem
                (ITEM_SEQ, ITEM_NAME, ENTP_NAME, ITEM_PERMIT_DATE, CANCEL_DATE,
                    ETC_OTC_CODE, CHANGE_DATE, CLASS_NO, CHART, PACK_UNIT, 
                    NB_DOC_DATA, EE_DOC_DATA, UD_DOC_DATA)
                values (:ITEM_SEQ, :ITEM_NAME, :ENTP_NAME, :ITEM_PERMIT_DATE, :CANCEL_DATE,
                    :ETC_OTC_CODE, :CHANGE_DATE, :CLASS_NO, :CHART, :PACK_UNIT,
                    :NB_DOC_DATA, :EE_DOC_DATA, :UD_DOC_DATA)"""
            try:
                db.execute_dml(sql, ITEM_SEQ=i.ITEM_SEQ, ITEM_NAME=i.ITEM_NAME, ENTP_NAME=i.ENTP_NAME,
                    ITEM_PERMIT_DATE=i.ITEM_PERMIT_DATE, NB_DOC_DATA=i.NB_DOC_DATA, CANCEL_DATE=i.CANCEL_DATE,
                    EE_DOC_DATA=i.EE_DOC_DATA, ETC_OTC_CODE=i.ETC_OTC_CODE, UD_DOC_DATA=i.UD_DOC_DATA,
                    CHANGE_DATE=i.CHANGE_DATE, CLASS_NO=i.CLASS_NO, CHART=i.CHART, PACK_UNIT=i.PACK_UNIT)
            except cx_Oracle.IntegrityError:
                sql = """update MdcinPrductItem set
                    ITEM_NAME=:ITEM_NAME, ENTP_NAME=:ENTP_NAME, ITEM_PERMIT_DATE=:ITEM_PERMIT_DATE,
                    CANCEL_DATE=:CANCEL_DATE, ETC_OTC_CODE=:ETC_OTC_CODE, CHANGE_DATE=:CHANGE_DATE,
                    CLASS_NO=:CLASS_NO, CHART=:CHART, PACK_UNIT=:PACK_UNIT,
                    NB_DOC_DATA=:NB_DOC_DATA, EE_DOC_DATA=:EE_DOC_DATA, UD_DOC_DATA=:UD_DOC_DATA
                    where ITEM_SEQ = :ITEM_SEQ"""
                try:
                    db.execute_dml(sql, ITEM_SEQ=i.ITEM_SEQ, ITEM_NAME=i.ITEM_NAME, ENTP_NAME=i.ENTP_NAME,
                        ITEM_PERMIT_DATE=i.ITEM_PERMIT_DATE, NB_DOC_DATA=i.NB_DOC_DATA, CANCEL_DATE=i.CANCEL_DATE,
                        EE_DOC_DATA=i.EE_DOC_DATA, ETC_OTC_CODE=i.ETC_OTC_CODE, UD_DOC_DATA=i.UD_DOC_DATA,
                        CHANGE_DATE=i.CHANGE_DATE, CLASS_NO=i.CLASS_NO, CHART=i.CHART, PACK_UNIT=i.PACK_UNIT)
                except cx_Oracle.DatabaseError as e:
                    print(e)
                    print('ITEM_SEQ: ', i.ITEM_SEQ)
            except cx_Oracle.DatabaseError as e:
                print(e)
                print('ITEM_SEQ: ', i.ITEM_SEQ)