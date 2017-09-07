import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userInterface {
	static java.sql.Connection con = connectivity.connectivity();

	public static void AddStudent(Student st, Courses cs) throws SQLException {
		PreparedStatement prs;
		String sql="INSERT into coursesStudents(courseId,studentId) SELECT id,? from Courses WHERE name=?";
		prs=con.prepareStatement(sql);
		prs.setInt(1, st.getCourseNumber());
		prs.setString(2, cs.getName());
		prs.executeUpdate();
		try{
		con.commit();
	}
	catch(SQLException e){
		e.printStackTrace();
		con.rollback();
	}
}
}
