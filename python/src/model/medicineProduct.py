class MedicineProductList:
    def __init__(self,
        ITEM_SEQ = None,
        ITEM_NAME = '',
        ENTP_NAME = '',
        ITEM_PERMIT_DATE = '',
        INDUTY = '',
        PRDLST_STDR_CODE = '',
        # CNSGN_MANUF = '',
        SPCLTY_PBLC = '',
        PRDUCT_TYPE = '',
        PRDUCT_PRMISN_NO = '',
        ITEM_INGR_NAME = '',
        ITEM_INGR_CNT = '',
        PERMIT_KIND_CODE = '',
        CANCEL_DATE = '',
        CANCEL_NAME = ''
    ):
        self.ITEM_SEQ = ITEM_SEQ
        self.ITEM_NAME = ITEM_NAME
        self.ENTP_NAME = ENTP_NAME
        self.ITEM_PERMIT_DATE = ITEM_PERMIT_DATE
        self.INDUTY = INDUTY
        self.PRDLST_STDR_CODE = PRDLST_STDR_CODE
        # self.CNSGN_MANUF = CNSGN_MANUF
        self.SPCLTY_PBLC = SPCLTY_PBLC
        self.PRDUCT_TYPE = PRDUCT_TYPE
        self.PRDUCT_PRMISN_NO = PRDUCT_PRMISN_NO
        self.ITEM_INGR_NAME = ITEM_INGR_NAME
        self.ITEM_INGR_CNT = ITEM_INGR_CNT
        self.PERMIT_KIND_CODE = PERMIT_KIND_CODE
        self.CANCEL_DATE = CANCEL_DATE
        self.CANCEL_NAME = CANCEL_NAME


class MedicineProductItem:
    def __init__(self,
        ITEM_SEQ=None,
        ITEM_NAME='',
        ENTP_NAME='',
        ITEM_PERMIT_DATE='',
        ETC_OTC_CODE='',
        CLASS_NO='',
        CHART='',
        BAR_CODE='',
        MATERIAL_NAME='',
        EE_DOC_ID='',
        UD_DOC_ID='',
        NB_DOC_ID='',
        INSERT_FILE='',
        STORAGE_METHOD='',
        VALID_TERM='',
        REEXAM_TARGET='',
        REEXAM_DATE='',
        PACK_UNIT='',
        EDI_CODE='',
        DOC_TEXT='',
        PERMIT_KIND_NAME='',
        ENTP_NO='',
        MAKE_MATERIAL_FLAG='',
        NEWDRUG_CLASS_NAME='',
        INDUTY_TYPE='',
        CANCEL_DATE='',
        CANCEL_NAME='',
        CHANGE_DATE='',
        NARCOTIC_KIND_CODE='',
        GBN_NAME='',
        EE_DOC_DATA='',
        UD_DOC_DATA='',
        NB_DOC_DATA='',
        PN_DOC_DATA='',
        INGR_NAME=''
    ):
        self.ITEM_SEQ = ITEM_SEQ
        self.ITEM_NAME = ITEM_NAME
        self.ENTP_NAME = ENTP_NAME
        self.ITEM_PERMIT_DATE = ITEM_PERMIT_DATE
        self.ETC_OTC_CODE = ETC_OTC_CODE
        self.CLASS_NO = CLASS_NO
        self.CHART = CHART
        self.BAR_CODE = BAR_CODE
        self.MATERIAL_NAME = MATERIAL_NAME
        self.EE_DOC_ID = EE_DOC_ID
        self.UD_DOC_ID = UD_DOC_ID
        self.NB_DOC_ID = NB_DOC_ID
        self.INSERT_FILE = INSERT_FILE
        self.STORAGE_METHOD = STORAGE_METHOD
        self.VALID_TERM = VALID_TERM
        self.REEXAM_TARGET = REEXAM_TARGET
        self.REEXAM_DATE = REEXAM_DATE
        self.PACK_UNIT = PACK_UNIT
        self.EDI_CODE = EDI_CODE
        self.DOC_TEXT = DOC_TEXT
        self.PERMIT_KIND_NAME = PERMIT_KIND_NAME
        self.ENTP_NO = ENTP_NO
        self.MAKE_MATERIAL_FLAG = MAKE_MATERIAL_FLAG
        self.NEWDRUG_CLASS_NAME = NEWDRUG_CLASS_NAME
        self.INDUTY_TYPE = INDUTY_TYPE
        self.CANCEL_DATE = CANCEL_DATE
        self.CANCEL_NAME = CANCEL_NAME
        self.CHANGE_DATE = CHANGE_DATE
        self.NARCOTIC_KIND_CODE = NARCOTIC_KIND_CODE
        self.GBN_NAME = GBN_NAME
        self.EE_DOC_DATA = EE_DOC_DATA
        self.UD_DOC_DATA = UD_DOC_DATA
        self.NB_DOC_DATA = NB_DOC_DATA
        self.PN_DOC_DATA = PN_DOC_DATA
        self.INGR_NAME = INGR_NAME


class NonMedicineProductList:
    def __init__(self,
        ITEM_SEQ = None,
        ITEM_NAME = '',
        EE_DOC_DATA='',
        UD_DOC_DATA='',
        NB_DOC_DATA='',
        CLASS_NO = '',
        CLASS_NO_NAME = '',
        ENTP_NAME = ''
    ):
        self.ITEM_SEQ = ITEM_SEQ
        self.ITEM_NAME = ITEM_NAME
        self.EE_DOC_DATA = EE_DOC_DATA
        self.UD_DOC_DATA = UD_DOC_DATA
        self.NB_DOC_DATA = NB_DOC_DATA
        self.CLASS_NO = CLASS_NO
        self.CLASS_NO_NAME = CLASS_NO_NAME
        self.ENTP_NAME = ENTP_NAME