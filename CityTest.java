import java.awt.Color;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/**
 * GUI for City Test from HW2
 * @author Madi Binyon
 * @version 1.00 13 January 2019
 */
  public class CityTest extends JFrame implements ActionListener, MouseMotionListener {
  /**
   * LN 17 - 75
   * Defining all JComponents, Array Lists, and URL Components for the GUI
   */
    private Point diffDrag;
    private JLayeredPane lpane;
    private JPanel panelMakePerson;
    private JPanel panelPersonInfo;
    private JLabel GoToSchool;
    private JLabel GoToCityHall;
    private JPanel MapPanel;

    private JFrame CHall;
    private JComboBox SendingPersonC;
    private JButton SendToSchool;
    private JLayeredPane SLayer;

    private JFrame EFrame;
    private JComboBox SendingPersonS;
    private JButton SendToCityHall;
    private JLayeredPane ELayer;

    private JButton ESchoolButton;
    private URL ESchoolURL;
    private ImageIcon ESIcon;
    private Image ESchoolimg;
    private JLabel SOccupantLabel;


    private JButton CHallButton;
    private URL CHallURL;
    private ImageIcon CHIcon;
    private Image CHallimg;
    private JLabel CHOccupantLabel;

    private JButton MakePolice;
    private JLabel PoliceIcon;
    private URL PoliceURL;
    private ImageIcon PIcon;
    private Image Policeimg;

    private JButton MakeKid;
    private JLabel KidIcon;
    private URL KidURL;
    private ImageIcon KIcon;
    private Image Kidimg;

    private JButton MakeTeacher;
    private JLabel TeacherIcon;
    private URL TeacherURL;
    private ImageIcon TIcon;
    private Image Teacherimg;
    private ArrayList<JLabel> People = new ArrayList<>();
    private ArrayList<JLabel> CHPeople = new ArrayList<>();
    private ArrayList<JLabel> SPeople = new ArrayList<>();

    private JTextField Name;
    private JTextField Age;
    private JTextField PhoneNumber;
    private JTextField Certification;
    private JTextField GradeLevel;
    private JTextField FaveCandy;
    private JComboBox PoliceR;

  /** CityTest constructor
   * LN 90 - 94, Setting parameters for JLayeredPane.  This makes it possible for icons to move on top of each other without disappearing to the user.
   * LN 96 - 105, Creating JLabels for the user to drag icons to in order to determine location of townspeople.  One with white color and one without color
   * to make it clear where the line between the two stands.
   * LN 107 - 119, MakePerson JPanel created, houses MakeTeacher, MakePolice, and MakeKid JButtons.  When any of these buttons are clicked, a new Person is
   * added to the People array list and an icon is created in the TopLeft JPanel.
   * LN 121 - 149, PersonInfo Panel holds all JLabels and JTextFields to gather information about the person being created from the user.
   * LN 151 - 152, Attempt to create JComboBoxes to be able to send certain persons from School to City Hall and vice versa.
   * LN 154 - 189, Creating MapPanel to house City Hall and School JButtons.  The buttons are marked by images of their respective buildings found online.
   * LN 191 - 219, Creating JFrame to house all JPanels previously mentioned using a GridBagLayout.
   */
  public CityTest() {
    lpane = new JLayeredPane();
    lpane.setPreferredSize(new Dimension(200,200));
    lpane.setBackground(Color.white);
    lpane.setOpaque(true);
    lpane.addMouseMotionListener(this);

      GoToCityHall = new JLabel("Go to City Hall");
      lpane.add(GoToCityHall, 0);
      GoToCityHall.setBounds(100,150,100,50);
      GoToCityHall.setOpaque(true);
      GoToCityHall.addMouseMotionListener(this);

      GoToSchool = new JLabel("Go to School");
      lpane.add(GoToSchool, 0);
      GoToSchool.setBounds(0,150,100,50);
      GoToSchool.addMouseMotionListener(this);

      panelMakePerson = new JPanel();

      MakeTeacher = new JButton("Make Teacher");
      panelMakePerson.add(MakeTeacher);
      MakeTeacher.addActionListener(this);

      MakePolice = new JButton("Make Police");
      panelMakePerson.add(MakePolice);
      MakePolice.addActionListener(this);

      MakeKid = new JButton("Make Kid");
      panelMakePerson.add(MakeKid);
      MakeKid.addActionListener(this);

      panelPersonInfo = new JPanel();
      panelPersonInfo.setLayout(new GridLayout(4,4));
      panelPersonInfo.add(new JLabel("name:"));
      Name = new JTextField();
      panelPersonInfo.add(Name);

      panelPersonInfo.add(new JLabel("age:"));
      Age = new JTextField();
      panelPersonInfo.add(Age);

      panelPersonInfo.add(new JLabel("phone number:"));
      PhoneNumber = new JTextField();
      panelPersonInfo.add(PhoneNumber);

      panelPersonInfo.add(new JLabel("certification:"));
      Certification = new JTextField();
      panelPersonInfo.add(Certification);

      panelPersonInfo.add(new JLabel("grade level:"));
      GradeLevel = new JTextField();
      panelPersonInfo.add(GradeLevel);

      panelPersonInfo.add(new JLabel("favorite candy:"));
      FaveCandy = new JTextField();
      panelPersonInfo.add(FaveCandy);

      panelPersonInfo.add(new JLabel("police role"));
      PoliceR = new JComboBox(Police.PoliceRole.values());
      panelPersonInfo.add(PoliceR);

      SendingPersonC = new JComboBox(SPeople.toArray());
      SendingPersonS = new JComboBox(CHPeople.toArray());

      MapPanel = new JPanel();
    try {
      Toolkit tk = Toolkit.getDefaultToolkit();
      ESchoolURL = new URL("http://chittagongit.com//images/elementary-school-icon/elementary-school-icon-3.jpg");
      ESchoolimg = tk.getImage(ESchoolURL);
      ESchoolimg = ESchoolimg.getScaledInstance(60, 40, Image.SCALE_SMOOTH);

      ESIcon = new ImageIcon(ESchoolimg);
      ESchoolButton = new JButton(ESIcon);          //Elementary School button click adds a new frame to the screen to see who the school occupants are
      MapPanel.add(ESchoolButton);
      MapPanel.revalidate();
      MapPanel.repaint();

    } catch (MalformedURLException f) {
      System.out.println(f.getMessage());
    }
      MapPanel.add(ESchoolButton);
      ESchoolButton.addActionListener(this);

    try {
      Toolkit tk = Toolkit.getDefaultToolkit();
      CHallURL = new URL("http://chittagongit.com//images/city-hall-icon/city-hall-icon-16.jpg");
      CHallimg = tk.getImage(CHallURL);
      CHallimg = CHallimg.getScaledInstance(60, 40, Image.SCALE_SMOOTH);

      CHIcon = new ImageIcon(CHallimg);
      CHallButton = new JButton(CHIcon);          //City Hall button click adds a new frame to the screen to see who the CH occupants are
      MapPanel.add(CHallButton);
      MapPanel.revalidate();
      MapPanel.repaint();

    } catch (MalformedURLException f) {
      System.out.println(f.getMessage());
    }
      MapPanel.add(CHallButton);
      CHallButton.addActionListener(this);

      JFrame topFrame = null;
      topFrame = new JFrame("City View");
      topFrame.add(lpane);
      topFrame.setSize(750,750);
      topFrame.addMouseMotionListener(this);
      topFrame.setVisible(true);
      topFrame.setLayout(new GridBagLayout());
      GridBagConstraints layoutConst = null;
      layoutConst = new GridBagConstraints();
      layoutConst.gridx = 0;
      layoutConst.gridy = 0;
      topFrame.add(lpane, layoutConst);
      layoutConst.insets = new Insets(10,10,10,10);

      layoutConst.gridx = 0;
      layoutConst.gridy = 1;
      topFrame.add(MapPanel, layoutConst);
      layoutConst.insets = new Insets(10,10,10,10);

      layoutConst.gridx = 1;
      layoutConst.gridy = 0;
      topFrame.add(panelMakePerson, layoutConst);
      layoutConst.insets = new Insets(10,10,10,10);

      layoutConst.gridx = 1;
      layoutConst.gridy = 1;
      topFrame.add(panelPersonInfo, layoutConst);
      layoutConst.insets = new Insets(10,10,10,10);
    }

  /** mouseDragged function
   *  LN 228, Setting the label to null so if it doesn't grab a viable object, it won't drag.
   *  LN 230-231, If an object (in this case a person icon) is clicked by the cursor, label will become that icon.
   *  LN 233 - 238, If the current label intersects with the School JLabel or the City Hall JLabel, that label will move into the School JFrame or City Hall JFrame respectively.
   *  LN 240 - 246, If label has been set to an icon, use diffDrag (from slides) to maneuver the icon to a new place on the LayeredPane.  Commented System.out for terminal readability.
   */
  public void mouseDragged(MouseEvent e) {
          JLabel label = null;
          for(int i = 0; i < People.size(); i++) {
            if (People.get(i).getBounds().contains(e.getPoint())) {
              label = People.get(i);
            }
            if (People.get(i).getBounds().intersects(GoToSchool.getBounds())) {
                SPeople.add(People.get(i));
            }
            if (People.get(i).getBounds().intersects(GoToCityHall.getBounds())) {
                CHPeople.add(People.get(i));
            }
          }
        if (label != null) {
          if (diffDrag == null)
            diffDrag = new Point(e.getX() - label.getBounds().x, e.getY() - label.getBounds().y);
          label.setBounds(e.getX() - diffDrag.x, e.getY() - diffDrag.y, label.getBounds().width, label.getBounds().height);
          //System.out.printf("moved label to <%d, %d>", e.getX() - diffDrag.x, e.getY() - diffDrag.y);
          }
        }

  /** mouseMoved function
   * LN 252, (From slides) Recognizes the mouse moving along the screen and sets diffDrag to null in order for mouseDragged to operate properly.
   */
  public void mouseMoved(MouseEvent e) {
          diffDrag = null;
      }

  /** actionPerformed function
   * LN 266 - 325, MakeTeacher, MakePolice, and MakeKid all have the same basic properties but differ in the type of Person being created and the icon shown when created.
   * When a button is pressed, that type of Person is created and their icon + name show up on the TopLeft JPanel.
   * Attempt was made at creating a "smart" function to discourage the user from making the Person have, for example, a ridiculous age or a non-existent phone
   * number.  I could not figure not how to get JTextField input to be recognized and compared to other strings. When the commented line (269) was used, no icon would
   * show even if the input was valid,
   * LN 326 - 370, If School or City Hall JButtons are pressed, a new JFrame pops up, showing the user what Person objects are present in that building.  Attempt was made to create
   * a JComboBox and JButton duo in order to move the people from the School to the City Hall and back, but I could not get the JComboBox to read in the members of the
   * SPeople (School Occupants) or CHPeople (City Hall Occupants) into a list a user could chose from.
   */

  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals(MakeTeacher)) {
      System.out.printf("%s is a %s year old %s grade teacher with a %s degree", Name.getText(), Age.getText(), GradeLevel.getText(), Certification.getText());
      //if (Age.getText().compareTo("20") > 0 && Age.getText().compareTo("100") < 0 && PhoneNumber.getText().compareTo("1000000") > 0 && PhoneNumber.getText().compareTo("9999999") < 0) {
        try {
          Toolkit tk = Toolkit.getDefaultToolkit();
          TeacherURL = new URL("http://chittagongit.com//images/teaching-icon-png/teaching-icon-png-28.jpg");
          Teacherimg = tk.getImage(TeacherURL);
          Teacherimg = Teacherimg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

          TIcon = new ImageIcon(Teacherimg);
          TeacherIcon = new JLabel(Name.getText(), TIcon, JLabel.CENTER);
          People.add(TeacherIcon);
          lpane.add(TeacherIcon, 400);
          TeacherIcon.setBounds(0, 0, 80, 30);
          lpane.revalidate();
          lpane.repaint();
        } catch (MalformedURLException f) {
          System.out.println(f.getMessage());
        }
    }
    else if (e.getSource().equals(MakeKid)) {
      System.out.printf("%s is a %s year old kid who loves %s", Name.getText(), Age.getText(), FaveCandy.getText());
        try {
          Toolkit tk = Toolkit.getDefaultToolkit();
          KidURL = new URL("http://chittagongit.com//images/child-icon/child-icon-7.jpg");
          Kidimg = tk.getImage(KidURL);
          Kidimg = Kidimg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

          KIcon = new ImageIcon(Kidimg);
          KidIcon = new JLabel(Name.getText(), KIcon, JLabel.CENTER);
          People.add(KidIcon);
          lpane.add(KidIcon);
          KidIcon.setBounds(0,0,80,30);
          lpane.revalidate();
          lpane.repaint();
        } catch (MalformedURLException f) {
          System.out.println(f.getMessage());
        }
    }
    else if (e.getSource().equals(MakePolice)) {
      System.out.printf("%s is a %s year old %s", Name.getText(), Age.getText(), PoliceR.getSelectedItem());
        try {
          Toolkit tk = Toolkit.getDefaultToolkit();
          PoliceURL = new URL("http://chittagongit.com//images/police-icon/police-icon-28.jpg");
          Policeimg = tk.getImage(PoliceURL);
          Policeimg = Policeimg.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

          PIcon = new ImageIcon(Policeimg);
          PoliceIcon = new JLabel(Name.getText(), PIcon, JLabel.CENTER);
          People.add(PoliceIcon);
          lpane.add(PoliceIcon);
          PoliceIcon.setBounds(0,0,80,30);
          lpane.revalidate();
          lpane.repaint();

        } catch (MalformedURLException f) {
          System.out.println(f.getMessage());
        }
    }
    else if(e.getSource() == ESchoolButton) {
      EFrame = new JFrame("Elementary School Occupants");
      EFrame.setSize(500, 500);
      EFrame.setVisible(true);
      ELayer = new JLayeredPane();
      ELayer.setSize(500,500);
      EFrame.add(ELayer);
      ELayer.addMouseMotionListener(this);
      SOccupantLabel = new JLabel();
      SOccupantLabel.addMouseMotionListener(this);
      EFrame.add(SOccupantLabel);
      SendToCityHall = new JButton("Send to City Hall");
      ELayer.add(SendToCityHall);
      SendToCityHall.setBounds(30,30,150,20);

      ELayer.add(SendingPersonC);
      SendingPersonC.addActionListener(this);
      SendingPersonC.setBounds(30,50,150,20);
      for (int i = 0; i < SPeople.size(); i++)
        SOccupantLabel.add(SPeople.get(i));
    }
    else if(e.getSource() == CHallButton) {
      CHall = new JFrame("City Hall Occupants");
      CHall.setSize(500,500);
      CHall.setVisible(true);

      SLayer = new JLayeredPane();
      SLayer.setSize(500,500);
      CHall.add(SLayer);
      SLayer.addMouseMotionListener(this);
      CHOccupantLabel = new JLabel();
      CHOccupantLabel.addMouseMotionListener(this);

      SendToSchool = new JButton("Send to School");
      CHall.add(SendToSchool);
      SendToSchool.setBounds(30,30,150,20);
      SendToSchool.addActionListener(this);

      CHall.add(SendingPersonS);
      SendingPersonS.setBounds(30,50,150,20);
      CHall.add(CHOccupantLabel);
        for (int i = 0; i < CHPeople.size(); i++)
          CHOccupantLabel.add(CHPeople.get(i));
    }
  }

  /**
   * LN 376, New test is created.  Original JFrame pops up when run.
   */
     public static void main(String[] args) {
        CityTest C = new CityTest();
    }
  }




  /* Employee Creation Test from HW2
  public static void main(String[] args) {

    for (int i = 0; i < cityBuildings.length; i++) {
      System.out.println(cityBuildings[i].toString());
    }

    for (int i = 0; i < population.length; i++) {
      System.out.println(population[i].toString());
    }

    for (int i = 0; i < population.length; i ++) {
      if (population[i] instanceof Employee) {
        ((Employee) population[i]).getID();
        ((Employee) population[i]).givePay(100);
        ((Employee) population[i]).getPay();
      }
    }

    for (int i = 0; i < population.length; i ++) {
      if (population[i] instanceof Employee) {
        ((Employee) population[i]).getID();
        ((Employee) population[i]).givePay(1000);
        ((Employee) population[i]).getPay();
      }
    }
   }
}
*/

