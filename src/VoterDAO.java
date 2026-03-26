import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VoterDAO {

    public void addVoter(Voter voter) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO voters (name) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, voter.getName());
            ps.executeUpdate();
            System.out.println("Voter added successfully!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Voter> getAllVoters() {
        List<Voter> voters = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM voters";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Voter v = new Voter(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("voted")
                );
                voters.add(v);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return voters;
    }

    public Voter getVoterById(int id) {
        Voter voter = null;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM voters WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                voter = new Voter(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("voted")
                );
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return voter;
    }

    public void markVoted(int voterId) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE voters SET voted=TRUE WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, voterId);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}