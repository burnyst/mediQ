from src.opendata.openDataPortal import OpenDataPortal
from src.model.medicineProduct import MedicineProductItem, MedicineProductList, NonMedicineProductList


class Mdfs(object):
    def __init__(self):
        self.resultCode = None
        self.__id = "1471057"

    def get(self, service, method, query):
        self.resultCode = None
        items = None
        open_data = OpenDataPortal(self.__id, service, method, query)
        if open_data is not None:
            self.resultCode = open_data.resultCode
            if self.resultCode == "00":
                items = open_data.body.items.find_all("item")
                if len(items) < 1:
                    print("item is empty.")
                    print(open_data.response)
            elif self.resultCode == "01":
                print("Application Error")
                print("-제공기관 서비스 제공 상태가 원할하지 않습니다.")
                print("-서비스 제공기관의 관리자에게 문의하시기 바랍니다.")
            elif self.resultCode == "02":
                print("DB Error")
                print("-제공기관 서비스 제공 상태가 원할하지 않습니다.")
                print("-서비스 제공기관의 관리자에게 문의하시기 바랍니다.")
            elif self.resultCode == "03":
                print("No Data")
            elif self.resultCode == "04":
                print("HTTP Error")
                print("-제공기관 서비스 제공 상태가 원할하지 않습니다.")
                print("-서비스 제공기관의 관리자에게 문의하시기 바랍니다.")
            elif self.resultCode == "05":
                print("service time out")
                print("-제공기관 서비스 제공 상태가 원할하지 않습니다.")
                print("-서비스 제공기관의 관리자에게 문의하시기 바랍니다.")
            elif self.resultCode == "10":
                print("잘못된 요청 파라미터 에러")
                print("-OpenApi 요청시 ServiceKey 파라미터가 없음")
                print("-OpenApi 요청 값에서 ServiceKey 파라미터가 누락되었습니다.")
                print("-OpenApi 요청 URL을 확인하시기 바랍니다.")
            elif self.resultCode == "11":
                print("필수 요청 파라미터가 없음")
                print("-요청하신 OpenApi의 필수 파라미터가 누락되었습니다.")
                print("-기술문서를 다시 한번 확인하시어 주시기 바랍니다.")
            elif self.resultCode == "12":
                print("해당 오픈 API 서비스가 없거나 폐기됨")
                print("-OpenApi 호출시 URL이 잘못됨")
                print("-제공기관 관리자에게 폐기된 서비스인지 확인합니다.")
                print("-폐기된 서비스가 아니면 개발가이드에서 OpenApi 요청 URL을 다시 확인하시기 바랍니다.")
            elif self.resultCode == "20":
                print("서비스 접근 거부")
                print("-활용 승인이 되지 않은 OpenApi 호출")
                print("-OpenAPI 활용신청정보의 승인상태를 확인하시기 바랍니다.")
                print("-활용신청에 대해 제공기관 담당자가 확인 후 '승인' 이후 부터 사용할 수 있습니다.")
                print("-신청 후 2~3일이 소요되고 결과는 회원가입 시 등록한 e-mail로 발송합니다.")
            elif self.resultCode == "22":
                print("서비스 요청 제한 횟수 초과 에러")
                print("-일일 활용건수가 초과함(활용건수 증가 필요)")
                print("-OpenAPI 활용신청정보의 서비스 상세기능 별 일일트래픽량을 확인하시기 바랍니다.")
                print("-개발계정의 경우 제공기관에서 정의한 트래픽을 초과하여 활용할 수 없습니다.")
                print("-운영계정의 경우 변경신청을 통해서 일일트래픽량을 변경할 수 있습니다.")
            elif self.resultCode == "30":
                print("등록되지 않은 서비스 키")
                print("-잘못된 서비스키를 사용하였거나 서비스키를 URL 인코딩하지 않음")
                print("-OpenAPI 활용신청정보의 발급받은 서비스키를 다시 확인하시기 바랍니다.")
                print("-서비스키 값이 같다면 서비스키가 URL 인코딩 되었는지 다시 확인하시기 바랍니다.")
            elif self.resultCode == "31":
                print("기한 만료된 서비스키")
                print("-OpenApi 사용기간이 만료됨(활용연장신청 후 사용가능)")
                print("-OpenAPI 활용신청정보의 활용기간을 확인합니다.")
                print("-활용기간이 지난 서비스는 이용할 수 없으며 연장신청을 통해 승인받은 후 다시 이용이 가능합니다.")
            elif self.resultCode == "32":
                print("등록되지 않은 도메인명 또는 IP 주소")
                print("-활용신청한 서버의 IP와 실제 OpenAPI 호출한 서버가 다를 경우")
                print("-OpenAPI 활용신청정보의 등록된 도메인명이나 IP주소를 다시 확인합니다.")
                print("-IP나 도메인의 정보를 변경하기 위해 변경신청을 할 수 있습니다.")
            else:
                print("request_api Unknown Error\n", "code:" + self.resultCode)
        return items

    def get_tag_text(self, tag):
        rst = ""
        if tag is not None:
            rst = tag.text.strip()
        return rst

    def get_doc_data(self, doc_data):
        rst = ""
        doc = doc_data.DOC
        doc_title = doc["title"].strip()
        if len(doc_title) > 0:
            rst += doc_title + "\n\n"
        sections = doc.find_all("SECTION")
        for section in sections:
            sec_title = section["title"].strip()
            if len(sec_title) > 0:
                rst += sec_title + "\n"
            articles = section.find_all("ARTICLE")
            for article in articles:
                art_title = article["title"].strip()
                if len(art_title) > 0:
                    rst += art_title + "\n"
                ps_text = ""
                ps = article.find_all("PARAGRAPH")
                for p in ps:
                    p_text = self.get_tag_text(p)
                    if len(p_text) > 0:
                        ps_text += p_text + "\n"
                if len(ps_text) > 0:
                    rst += ps_text + "\n"

        return rst.strip()


class MedicineProductPermissionInfo(Mdfs):
    def __init__(self):
        super().__init__()
        self.__service = "MdcinPrductPrmisnInfoService"
        self.__svc_key = ""

    def select_list(self, page_no=1, num_of_rows=10):
        rst = []
        query = "ServiceKey=" + self.__svc_key + "&pageNo=" + str(page_no) + "&numOfRows=" + str(num_of_rows)
        items = self.get(self.__service, "getMdcinPrductList", query)
        if self.resultCode == "00":
            for i in items:
                item = MedicineProductList(
                    self.get_tag_text(i.ITEM_SEQ),
                    self.get_tag_text(i.ITEM_NAME),
                    self.get_tag_text(i.ENTP_NAME),
                    self.get_tag_text(i.ITEM_PERMIT_DATE),
                    self.get_tag_text(i.INDUTY),
                    self.get_tag_text(i.PRDLST_STDR_CODE),
                    # self.get_tag_text(i.CNSGN_MANUF),
                    self.get_tag_text(i.SPCLTY_PBLC),
                    self.get_tag_text(i.PRDUCT_TYPE),
                    self.get_tag_text(i.PRDUCT_PRMISN_NO),
                    self.get_tag_text(i.ITEM_INGR_NAME),
                    self.get_tag_text(i.ITEM_INGR_CNT),
                    self.get_tag_text(i.PERMIT_KIND_CODE),
                    self.get_tag_text(i.CANCEL_DATE),
                    self.get_tag_text(i.CANCEL_NAME)
                )
                rst.append(item)
        return rst

    def select_item(self, page_no=1, num_of_rows=10):
        rst = []
        query = "ServiceKey=" + self.__svc_key + "&pageNo=" + str(page_no) + "&numOfRows=" + str(num_of_rows)
        print(query)
        items = self.get(self.__service, "getMdcinPrductItem", query)
        if self.resultCode == "00":
            for i in items:
                item = MedicineProductItem(
                    self.get_tag_text(i.ITEM_SEQ),
                    self.get_tag_text(i.ITEM_NAME),
                    self.get_tag_text(i.ENTP_NAME),
                    self.get_tag_text(i.ITEM_PERMIT_DATE),
                    self.get_tag_text(i.ETC_OTC_CODE),
                    self.get_tag_text(i.CLASS_NO),
                    self.get_tag_text(i.CHART),
                    self.get_tag_text(i.BAR_CODE),
                    self.get_tag_text(i.MATERIAL_NAME),
                    self.get_tag_text(i.EE_DOC_ID),
                    self.get_tag_text(i.UD_DOC_ID),
                    self.get_tag_text(i.NB_DOC_ID),
                    self.get_tag_text(i.INSERT_FILE),
                    self.get_tag_text(i.STORAGE_METHOD),
                    self.get_tag_text(i.VALID_TERM),
                    self.get_tag_text(i.REEXAM_TARGET),
                    self.get_tag_text(i.REEXAM_DATE),
                    self.get_tag_text(i.PACK_UNIT),
                    self.get_tag_text(i.EDI_CODE),
                    self.get_tag_text(i.DOC_TEXT),
                    self.get_tag_text(i.PERMIT_KIND_NAME),
                    self.get_tag_text(i.ENTP_NO),
                    self.get_tag_text(i.MAKE_MATERIAL_FLAG),
                    self.get_tag_text(i.NEWDRUG_CLASS_NAME),
                    self.get_tag_text(i.INDUTY_TYPE),
                    self.get_tag_text(i.CANCEL_DATE),
                    self.get_tag_text(i.CANCEL_NAME),
                    self.get_tag_text(i.CHANGE_DATE),
                    self.get_tag_text(i.NARCOTIC_KIND_CODE),
                    self.get_tag_text(i.GBN_NAME),
                    self.get_tag_text(i.EE_DOC_DATA),
                    self.get_tag_text(i.UD_DOC_DATA),
                    self.get_tag_text(i.NB_DOC_DATA),
                    self.get_tag_text(i.PN_DOC_DATA),
                    self.get_tag_text(i.INGR_NAME)
                )
                rst.append(item)
        return rst


class NonMedicineProductPermissionInfo(Mdfs):
    def __init__(self):
        super().__init__()
        self.__service = "NonMdcinPrductPrmisnInfoService"
        self.__svc_key = ""

    def select_list(self, page_no=1, num_of_rows=10):
        rst = []
        query = "ServiceKey=" + self.__svc_key + "&pageNo=" + str(page_no) + "&numOfRows=" + str(num_of_rows)
        items = self.get(self.__service, "getNonMdcinPrductPrmisnInfoList", query)
        if self.resultCode == "00":
            for i in items:
                item = NonMedicineProductList(
                    self.get_tag_text(i.ITEM_SEQ),
                    self.get_tag_text(i.ITEM_NAME),
                    self.get_doc_data(i.EE_DOC_DATA),
                    self.get_doc_data(i.UD_DOC_DATA),
                    self.get_doc_data(i.NB_DOC_DATA),
                    self.get_tag_text(i.CLASS_NO),
                    self.get_tag_text(i.CLASS_NO_NAME),
                    self.get_tag_text(i.ENTP_NAME)
                )
                rst.append(item)
        return rst


if __name__ == "__main__":
    mdc_info = MedicineProductPermissionInfo()
    # items = mdc_info.select_list()
    # if mdc_info.resultCode == "00":
    #     for i in items:
    #         print(i)
    #         print()

    items = mdc_info.select_item()
    if mdc_info.resultCode == "00":
        for i in items:
            print("분류:", i.CLASS_NO)
            print("업체명:", i.ENTP_NAME)
            print("제품명:", i.ITEM_NAME)
            print("효능:", i.EE_DOC_DATA)
            print("사용법:", i.UD_DOC_DATA)
            print("주의사항:", i.NB_DOC_DATA)
            print()

    # non_mdc_info = NonMedicineProductPermissionInfo()
    # items = non_mdc_info.select_list()
    # if non_mdc_info.resultCode == "00":
    #     for i in items:
    #         print("분류:", i.CLASS_NO_NAME)
    #         print("업체명:", i.ENTP_NAME)
    #         print("제품명:", i.ITEM_NAME)
    #         print("효능:", i.EE_DOC_DATA)
    #         print("사용법:", i.UD_DOC_DATA)
    #         print("주의사항:", i.NB_DOC_DATA)
    #         print()
