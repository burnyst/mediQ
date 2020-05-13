package newsModel;

import java.util.Date;

public class News {
		private Integer sn;
		private String mid;
		private String title;
		private String press;
		private String summary;
		private Date rdate;
		private	String nimage;
		
		public News(Integer sn,
				String mid, String title, 
				String press, String summary, 
				Date rdate, String nimage) {
				this.sn = sn;
				this.mid = mid;
				this.title = title;
				this.press = press;
				this.summary = summary;
				this.rdate = rdate;
				this.nimage = nimage;
		}

		public Integer getSn() {
			return sn;
		}

		public void setSn(Integer sn) {
			this.sn = sn;
		}

		public String getMid() {
			return mid;
		}

		public void setMid(String mid) {
			this.mid = mid;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getPress() {
			return press;
		}

		public void setPress(String press) {
			this.press = press;
		}

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public Date getRdate() {
			return rdate;
		}

		public void setRdate(Date rdate) {
			this.rdate = rdate;
		}

		public String getNimage() {
			return nimage;
		}

		public void setNimage(String nimage) {
			this.nimage = nimage;
		}

		@Override
		public String toString() {
			return "News [sn=" + sn + ", mid=" + mid + ", title=" + title + ", press=" + press + ", summary=" + summary
					+ ", rdate=" + rdate + ", nimage=" + nimage + "]";
		}
		
		
}


