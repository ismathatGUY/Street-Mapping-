Name: Ismael Kabore
Lab section: M/W 2:00 PM - 3:15 PM at Gavett 244,
Net Id: ikabore
Project: 3

Instructions for Running the Program:

Go to the command line, make sure to be in the correct directory. 

Compile:

javac StreetMap.java 
java StreetMap ur.txt --show (for displaying the map)
java StreetMap ur.txt --show --directions LOVEJOY ANDERSON (for displaying the map and directions).

NB: Resize the window to a full to see the map and background. 




Descriptions:

A JAVA program that reads formatted data on the intersections and roads that make up a map, creates 
a graph using that data, displays the graph using Java Graphics, and calculates the shortest path 
between two intersections and the minimum weight spanning tree if prompted to do so.


StreetMap class(Main):

This program is a Java implementation of a StreetMap, which allows you to visualize a map and find the shortest path between two intersections. It takes a data file as input, which contains the information about the map, and displays the map using a graphical user interface (GUI). It can also provide directions between two intersections by finding the shortest path between them.
The program takes the following arguments:

<data-file>: The path to the data file that contains the information about the map.
--show: Optional flag to display the map using a graphical user interface (GUI).
--directions start_intersection end_intersection: Optional flag to find the shortest path between two intersections.

If you provide the --show flag, the program will display the map using a GUI. If you provide the --directions flag, you also need to provide the names of the start and end intersections.
Code Explanation

The StreetMap class is the main class of the program. It reads the input data file, creates a Graph object, and processes the command line arguments to display the map or find directions.
The Graph class is responsible for creating the graph of the map and finding the shortest path between two intersections. It has methods to parse the input data file and store the information about the intersections and roads in the graph. It also has a method to find the shortest path between two intersections using Dijkstra's algorithm.
The GUI class is responsible for displaying the map using a graphical user interface (GUI). It takes the information about the intersections and roads from the Graph object and displays them using Java's Swing library.

Dependencies
This program depends on Java and the Java Swing library for displaying the GUI. No additional libraries are required.

Limitations
This program has the following limitations:
It only supports maps with intersections and roads.
It assumes that the input data file is formatted correctly and does not perform any error checking.
It does not provide any real-time information about traffic or road closures.



Road Class:

The Road class is a simple data class that represents a road in the map. It has three attributes:

id: A string that represents the unique identifier of the road.
destinationID: A string that represents the unique identifier of the intersection that the road leads to.

weight: A double that represents the distance or cost of traveling on this road.
The Road class has a constructor that takes the id, destinationID, and weight as parameters and initializes the corresponding attributes.


Heap Class:

The Heap class is an implementation of a min-heap data structure. It is used in the Graph class to efficiently find the shortest path between two intersections.

The Heap class has five attributes:

hashMap: A HashMap that maps an intersection ID to its index in the heap.
size: An integer that represents the number of elements in the heap.

heap: A list that stores the indices of the intersections in the heap.
intersectionId: A list that stores the IDs of the intersections.
value: A list that stores the values associated with the intersections.
The Heap class has several methods for manipulating the heap:

swap(int i, int j): Swaps the elements at indices i and j in the heap.
up(int index): Performs the "up" operation on the element at index index in the heap.
down(int index): Performs the "down" operation on the element at index index in the heap.
removeTop(): Removes the top element from the heap and returns its intersection ID.

getValue(String id): Returns the value associated with the intersection with the given ID.
updateValue(String id, double w): Updates the value associated with the intersection with the given ID and performs the "up" operation to maintain the heap property.

containIntersection(String id): Returns true if the heap contains the intersection with the given ID.
addElement(String id, double w): Adds a new element with the given ID and value to the heap and performs the "up" operation to maintain the heap property.


GUI class:

This is a Java class that extends the JPanel class and defines a GUI for displaying a map of a city. Here are some key points about this class:

The GUI class has a constructor that takes a HashMap of Intersection objects and a Set of road IDs as parameters. The Intersection objects represent the intersections in the city, and the road IDs represent the roads that are highlighted in the GUI.
The constructor initializes several instance variables, including the intersections, the road IDs, and the minimum and maximum latitude and longitude values of the intersections.
The GUI is created using a JFrame object, which is set to a fixed size of 1000 x 600 pixels. The JFrame is initialized with the JPanel object created by this class, and the JFrame is set to be visible.
The adjustedLatitude() and adjustedLongitude() methods take a latitude or longitude value, respectively, and return a pixel value that is adjusted for the size of the JPanel and the range of the latitude or longitude values of the intersections.
The paintComponent() method is called whenever the JPanel needs to be repainted. It first loads and draws a background image, and then draws the city name in the upper left corner of the panel. Finally, it draws the roads and intersections on the panel, using the adjustedLatitude() and adjustedLongitude() methods to determine the pixel coordinates of the intersections and roads.
The getPreferredSize() method returns a Dimension object that represents the preferred size of the JPanel. This is calculated based on the range of the latitude and longitude values of the intersections, and a padding value is added to ensure that all of the intersections and roads fit within the JPanel.

Graph class:

The "Intersection" class is used to represent an intersection in a road network. An intersection is defined by its unique identifier, latitude, and longitude. This class also contains a list of roads that connect to this intersection.

The constructor for this class takes three parameters: the intersection's identifier, latitude, and longitude. The constructor initializes an empty list of roads for the intersection.

The "addRoad" method is used to add a road that connects to the intersection. It takes a "Road" object as a parameter and adds it to the intersection's road list.

The "getLatitude" and "getLongitude" methods are used to retrieve the latitude and longitude values of the intersection.

Overall, the "Intersection" class provides a way to represent intersections in a road network and maintain information about the roads that connect to them.


Intersection Class:

The Intersection class represents a location on a map with a latitude and longitude. It has a unique id and a list of roads that intersect at this location.

Attributes:

id: a String representing the unique id of the intersection
latitude: a double representing the latitude coordinate of the intersection
longitude: a double representing the longitude coordinate of the intersection
roadList: a List of Road objects representing the roads that intersect at this intersection.
Methods:

Intersection(String id, double latitude, double longitude): constructor that takes an id, latitude, and longitude, and initializes the Intersection object with those values.
addRoad(Road road): adds a Road object to the list of roads at this intersection.
getLatitude(): returns the latitude coordinate of the intersection.
getLongitude(): returns the longitude coordinate of the intersection.


Notable obstacles:

Understanding the underlying data structures: The code uses a HashMap to store the intersections, and it was challenging  to understand how to work with this data structure. Similarly, the Intersection and Road classes define custom objects that required some understanding of object-oriented programming concepts.

Resizing the display window: The original code did not display the entire map, so it was necessary to resize the window. However, it can be challenging to determine the correct size for the window, especially if the map data is not evenly distributed.

Working with graphics: The code uses the Graphics2D class to draw the map, and it was challenging for to use this class effectively. For example, it may not be immediately obvious how to change the line color or thickness.

Performance issues: Depending on the size of the map data, there may be performance issues with rendering the map. For example, if there are many intersections and roads, the code may take a long time to execute, and the map may be slow to display or update. It may be necessary to optimize the code or find ways to reduce the amount of data that needs to be displayed.


Runtime Analysis:

parseData method:

The method reads the data from a file and creates Intersection and Road objects based on the data.
The time complexity of the method is O(n), where n is the number of lines in the file. The method reads each line once and performs constant time operations on each line.
haversineFunction method:

The method calculates the haversine distance between two intersections using their latitude and longitude values.
The time complexity of the method is O(1), as it performs only arithmetic operations that take constant time.
shortestPath method:

The method implements Dijkstra's shortest path algorithm to find the shortest path between two intersections.
The time complexity of the method is O((E+V)logV), where E is the number of edges, V is the number of vertices (intersections), and logV is the time complexity of the heap operations used in the algorithm.
The worst-case scenario is when all intersections are connected to each other, making E = V^2. In this case, the time complexity becomes O(V^2 logV).
Overall, the time complexity of the program is dominated by the shortestPath method, which has a time complexity of O((E+V)logV).


Files Handed In:

For an intersection, the line starts with the letter "i" followed by the intersection id, latitude, and longitude separated by spaces.
For a road, the line starts with the letter "r" followed by the road id, the intersection id of the first endpoint, and the intersection id of the second endpoint separated by spaces.
Here are the input and output for each method:

parseData(String fileName):
Input: fileName is a String representing the name of the input file containing the intersection and road information.

Output: This method does not have a return value but populates the Intersections HashMap with Intersection objects and their associated Road objects.
haversineFunction(Intersection i1, Intersection i2):

Input: i1 and i2 are Intersection objects representing the two endpoints of a road.
Output: This method returns a double value representing the distance between the two intersections using the haversine formula.
shortestPath(String start, String end):
Input: start and end are Strings representing the ids of the starting and ending intersections, respectively.

Output: This method prints out the shortest path between the starting and ending intersections, and the distance traveled in kilometers. If a path cannot be found, it prints "Can't find path". The output is printed to the console.
Overall, the input for all methods is the information about intersections and roads in the input file, and the output is either populating a HashMap with Intersection and Road objects, calculating the distance between two intersections, or finding and printing the shortest path between two intersections.

ur_campus.txt contains the formatted data for the University of Rochester campus as provided with the assignment.
monroe.txt contains the formatted data for Monroe county as provided with the assignment.
nys.txt contains the formatted data for New York State as provided with the assignment.
README.txt









