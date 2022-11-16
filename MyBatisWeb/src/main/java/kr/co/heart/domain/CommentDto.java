package kr.co.heart.domain;

import java.util.Date;
import java.util.Objects;

/*
 	 cno            serial
,    bno            int        not null
,    pcno           int
,    comment        varchar(3000)
,    commenter      varchar(30)
,    reg_date       date    default now()
,    up_date        date    default now()
,    primary key(cno)
*/

public class CommentDto {
	private Integer con;
	private Integer bno;
	private Integer pcno;
	private String comment;
	private String commenter;
	private Date reg_date;
	private Date up_date;
	
	public CommentDto() {
		
	}

	public CommentDto(Integer bno, Integer pcno, String comment, String commenter) {
		//super();
		this.bno = bno;
		this.pcno = pcno;
		this.comment = comment;
		this.commenter = commenter;
	}

	public Integer getCon() {
		return con;
	}

	public void setCon(Integer con) {
		this.con = con;
	}

	public Integer getBno() {
		return bno;
	}

	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public Integer getPcno() {
		return pcno;
	}

	public void setPcno(Integer pcno) {
		this.pcno = pcno;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getUp_date() {
		return up_date;
	}

	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}

	@Override
	public String toString() {
		return "CommentDto [con=" + con + ", bno=" + bno + ", pcno=" + pcno + ", comment=" + comment + ", commenter="
				+ commenter + ", reg_date=" + reg_date + ", up_date=" + up_date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bno, comment, commenter, con, pcno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentDto other = (CommentDto) obj;
		return Objects.equals(bno, other.bno) && Objects.equals(comment, other.comment)
				&& Objects.equals(commenter, other.commenter) && Objects.equals(con, other.con)
				&& Objects.equals(pcno, other.pcno);
	}
	
	
	
}


