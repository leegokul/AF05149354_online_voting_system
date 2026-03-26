import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VoterDAO voterDAO = new VoterDAO();
        CandidateDAO candidateDAO = new CandidateDAO();
        VoteDAO voteDAO = new VoteDAO();

        while (true) {
            System.out.println("\n--- Online Voting System ---");
            System.out.println("1. Add Voter");
            System.out.println("2. Add Candidate");
            System.out.println("3. Cast Vote");
            System.out.println("4. List Voters");
            System.out.println("5. List Candidates");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter voter name: ");
                    String voterName = sc.nextLine();
                    voterDAO.addVoter(new Voter(0, voterName, false));
                    break;

                case 2:
                    System.out.print("Enter candidate name: ");
                    String candidateName = sc.nextLine();
                    candidateDAO.addCandidate(new Candidate(0, candidateName, 0));
                    break;

                case 3:
                    System.out.print("Enter voter ID: ");
                    int voterId = sc.nextInt();
                    Voter voter = voterDAO.getVoterById(voterId);
                    if (voter == null) {
                        System.out.println("Invalid voter ID!");
                        break;
                    }
                    if (voter.isVoted()) {
                        System.out.println("Voter has already voted!");
                        break;
                    }
                    List<Candidate> candidates = candidateDAO.getAllCandidates();
                    System.out.println("--- Candidates ---");
                    for (Candidate c : candidates) {
                        System.out.println(c.getId() + ". " + c.getName() + " (" + c.getVotes() + " votes)");
                    }
                    System.out.print("Enter candidate ID to vote: ");
                    int candidateId = sc.nextInt();
                    voteDAO.castVote(voterId, candidateId);
                    break;

                case 4:
                    List<Voter> voters = voterDAO.getAllVoters();
                    System.out.println("--- Voter List ---");
                    for (Voter v : voters) {
                        System.out.println(v.getId() + ". " + v.getName() + " | Voted: " + v.isVoted());
                    }
                    break;

                case 5:
                    List<Candidate> allCandidates = candidateDAO.getAllCandidates();
                    System.out.println("--- Candidate List ---");
                    for (Candidate c : allCandidates) {
                        System.out.println(c.getId() + ". " + c.getName() + " | Votes: " + c.getVotes());
                    }
                    break;

                case 6:
                    System.out.println("Exiting... Bye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
