import java.sql.Connection;
import java.sql.PreparedStatement;

public class VoteDAO {

    public void castVote(int voterId, int candidateId) {
        try {
            Connection con = DBConnection.getConnection();

            // Add vote to votes table
            String sql = "INSERT INTO votes (voter_id, candidate_id) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, voterId);
            ps.setInt(2, candidateId);
            ps.executeUpdate();

            // Increment candidate votes
            CandidateDAO candidateDAO = new CandidateDAO();
            candidateDAO.incrementVote(candidateId);

            // Mark voter as voted
            VoterDAO voterDAO = new VoterDAO();
            voterDAO.markVoted(voterId);

            System.out.println("Vote cast successfully!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
