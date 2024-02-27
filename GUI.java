import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GUI extends JPanel {
    HashMap<String, Intersection> intersections;
    double minLat, maxLat, minLong, maxLong;
    int padding = 200;
    Set<String> roadIDs;

    public GUI(HashMap<String, Intersection> list, Set<String> roadIDs) throws HeadlessException {
        this.intersections = list;
        this.roadIDs = roadIDs;
        minLat = 200;
        maxLat = -200;
        minLong = 200;
        maxLong = -200;
        for (String key : intersections.keySet()) {
            Intersection intersection = intersections.get(key);
            minLat = Math.min(minLat, intersection.getLatitude());
            maxLat = Math.max(maxLat, intersection.getLatitude());
            minLong = Math.min(minLong, intersection.getLongitude());
            maxLong = Math.max(maxLong, intersection.getLongitude());
        }
        JFrame frame = new JFrame();
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);
        frame.revalidate();
        this.repaint();
    }


    int adjustedLatitude(double latitude) {
        return (int) ((maxLat - latitude) / (maxLat - minLat) * this.getHeight());
    }

    int adjustedLongitude(double longitude) {
        return (int) ((longitude - minLong) / (maxLong - minLong) * this.getWidth());
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        // Load the background image
        ImageIcon imageIcon = new ImageIcon("map_background.jpg");
        Image backgroundImage = imageIcon.getImage();

        // Draw the background image
        g2D.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);

        // Draw the city name
        Font font = new Font("Serif", Font.BOLD, 30);
        g2D.setFont(font);
        g2D.setColor(Color.WHITE);
        g2D.drawString("My City", 20, 50);

        // Draw the roads and intersections
        for (String key : intersections.keySet()) {
            Intersection intersection = intersections.get(key);
            for (Road road : intersection.roadList) {
                g2D.drawLine(
                        adjustedLongitude(intersection.getLongitude()),
                        adjustedLatitude(intersection.getLatitude()),
                        adjustedLongitude(intersections.get(road.destinationID).getLongitude()),
                        adjustedLatitude(intersections.get(road.destinationID).getLatitude()));
                if (roadIDs.contains(road.id)) {
                    g2D.setColor(new Color(255, 255, 153));
                    g2D.setStroke(new BasicStroke(3));
                    g2D.drawLine(
                            adjustedLongitude(intersection.getLongitude()),
                            adjustedLatitude(intersection.getLatitude()),
                            adjustedLongitude(intersections.get(road.destinationID).getLongitude()),
                            adjustedLatitude(intersections.get(road.destinationID).getLatitude()));
                    g2D.setColor(new Color(0, 0, 0));
                    g2D.setStroke(new BasicStroke(1));
                }
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 600);
    }
}
