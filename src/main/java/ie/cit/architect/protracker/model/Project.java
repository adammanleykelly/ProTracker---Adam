package ie.cit.architect.protracker.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by brian on 08/03/17.
 */
public class Project implements IProject{

    private int projectId;
    private static int count = 0;
    private static AtomicInteger next_id = new AtomicInteger(0);
    private String name;
    private Date date;
    private String author;
    private String location;
    private String clientName;
    private ArrayList<Project> projectNames;


    public Project() {}

    public Project(int projectId, String name, Date date) {
        this.projectId = Project.next_id.incrementAndGet();
        this.name = name;
        this.date = date;
    }


    public Project(String name, String author, String location, String clientName) {
        this.projectId = Project.next_id.incrementAndGet();
        this.name = name;
        setDate(new Date());
        this.author = author;
        this.location = location;
        this.clientName = clientName;
    }

    public ArrayList<Project> getProjectNames() {
        return projectNames;
    }

    public void setProjectNames(ArrayList<Project> projectNames) {
        this.projectNames = projectNames;
    }


    @Override
    public String getLocation() {
        return location;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getClientName() {
        return clientName;
    }

    @Override
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }


    public String getFormattedDate() {

        String inputPattern = "E MMM dd HH:mm:ss z yyyy";
        String outputPattern = "dd-MMM-yy HH:mm:ss a";
        String dateFormatted = "";
        Date currentDate;
        try {

            String d = String.valueOf(this.date);
            SimpleDateFormat sdf = new SimpleDateFormat(inputPattern, Locale.ENGLISH);
            currentDate = sdf.parse(d);

            SimpleDateFormat sdf2 = new SimpleDateFormat(outputPattern);
            dateFormatted = sdf2.format(currentDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateFormatted;

    }

}
