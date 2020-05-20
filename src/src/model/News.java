package model;

import java.util.Date;

public class News {
		private User user;
		private Integer sn;
		private String mid;
		private String title;
		private String press;
		private String summary;
		private Date rdate;
		private	String nimage;
		
		public News(Integer sn) {
			this.sn=sn;
		}
		
		
		public News(
				String title) {
				this.title = title;
		}
		
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
		public News(Integer sn,
				String title, 
				String press, String summary, 
				Date rdate, String nimage, User user ) {
				this.sn = sn;
				this.mid = user.getMid();
				this.title = title;
				this.press = press;
				this.summary = summary;
				this.rdate = rdate;
				this.nimage = nimage;
				this.user = user;
		}
		public News() {
		}
		public News(Integer sn,String title, String summary) {
			this.sn = sn;
			this.title = title;
			this.summary = summary;
		}

		public News(int sn, User user, String title, String press, String summary, Date rdate, String nimage) {
			this.sn = sn;
			this.mid = user.getMid();
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

		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
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
			return "News [user=" + user + ", sn=" + sn + ", mid=" + mid + ", title=" + title + ", press=" + press
					+ ", summary=" + summary + ", rdate=" + rdate + ", nimage=" + nimage + "]";
		}


		

		
		
		
}


