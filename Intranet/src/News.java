import java.io.Serializable;
import java.util.Date;

public class News  implements Serializable,Comparable  {
	String redLine;
	String text;
	String loginOfAuthor;
	Date postedAt;
    
    News(String redLine,String text,String loginOfAuthor) {
    	this.redLine = redLine;
    	this.text = text;
    	this.loginOfAuthor = loginOfAuthor;
    	postedAt = new Date();
    }
    public String toString() {
    	String res = "";
    	res += redLine;
    	res += "\n";
    	res += text;
    	res += "\n";
    	res += "posted by:" + loginOfAuthor + " " + "at: " + postedAt.toString();
    	return res;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof News)) return false;
        News news = (News) obj;
        return super.equals(obj);
    }

    public int compareTo(News a) {
    	return this.postedAt.compareTo(a.postedAt);
    }
    public int hashCode() { return super.hashCode(); }
	@Override
	public int compareTo(Object o) {
		return this.postedAt.compareTo(((News)o).postedAt);
	}
}