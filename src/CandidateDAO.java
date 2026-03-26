import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {

    public void addCandidate(Candidate candidate) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO candidates (name) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, candidate.getName());
            ps.executeUpdate();
            System.out.println("Candidate added successfully!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Candidate> getAllCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM candidates";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Candidate c = new Candidate(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("votes")
                );
                candidates.add(c);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return candidates;
    }

    public void incrementVote(int candidateId) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE candidates SET votes = votes + 1 WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, candidateId);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}