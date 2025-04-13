package project1telegramoop;

import java.util.ArrayList;
import java.util.List;

public class Group extends Users{
    private int groupID;
    private String groupName;
    private String groupLink;
    private String leader;
    private List<String> members;

    public Group(int userID, String userName, String firstName, String lastName, String email, String phoneNumber, String message, String behavior, int groupID, String groupName, String groupLink, String leader) {
        super(userID, userName, firstName, lastName, email, phoneNumber, message, behavior);
        this.groupID = groupID;
        this.groupName = groupName;
        this.groupLink = groupLink;
        this.leader = leader;
        this.members = new ArrayList<>();
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }
    public int getGroupID() {
        return groupID;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupLink(String groupLink) {
        this.groupLink = groupLink;
    }
    public String getGroupLink() {
        return groupLink;
    }
    public void setLeader(String leader) {
        this.leader = leader;
    }
    public String getLeader() {
        return leader;
    }
    public void setMember(String member) {
        this.member = member;
    }
    public String getMember() {
        return member;
    }
    public boolean isMember(String member) {
        return members.contains(member);
    }
    public void addMember(String member) {
        if (isMember(member)) {
            System.out.println("Member " + member + " is already in the group " + groupName);
            return;
        }
        members.add(member);
        System.out.println("Member " + member + " has been added to the group " + groupName);
    }
    public void kickMember(String member) {
        if (!isMember(member)) {
            System.out.println("Member " + member + " is not in the group " + groupName);
            return;
        }
        members.remove(member);
        System.out.println("Member " + member + " has been kicked from the group " + groupName);
    }
    public void deleteGroup() {
        members.clear();
        System.out.println("Group " + groupName + " has been deleted.");
    }
    public void outGroup(String member){
        members.remove(member.getUserName());
        System.out.println("You have left the group " + groupName);
    }
    public void tagMember(String member){
        
    }
}
