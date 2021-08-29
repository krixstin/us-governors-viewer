# us-governors-viewer

This application is written in Java and utilized Java Database Connectivity with SQL database of US governors. 
The application first excute the list of (US States full name & code) pairs, then takes in input of **State Code**, and returns 

- name
- phone number
- party
- gender
- ethnicity
- biography
- contact page link

of governor of a requested State

## Demo
![image](https://user-images.githubusercontent.com/55266110/131237586-891592eb-69de-4c54-a4b0-6a41406a496c.png)

## Code Snippets
![image](https://user-images.githubusercontent.com/55266110/131237701-17db59e5-2489-43e4-a3ad-7cf09b8c353c.png)

|Class/Interface|
|---|
|![image](https://user-images.githubusercontent.com/55266110/131237797-0e39e39a-0ca3-455a-b5b4-0ca8e6ebf91f.png)|Connection conn = DriverManager.getConnection(dburl, user, password);|
|A connection (session) with a specificdatabase. SQL statements are executed and results are returnedwithin the context of a connection. |
|**Connection conn = DriverManager.getConnection(dburl, user, password);**|
||
|![image](https://user-images.githubusercontent.com/55266110/131237817-cbf01f7a-46e0-4c57-94a1-8acc8ca1aeec.png)
|An object that represents a precompiled SQL statement. |
|**PreparedStatement ps = conn.prepareStatement(sql);**|
||
|![image](https://user-images.githubusercontent.com/55266110/131237838-1666f00c-bdb9-4a53-83de-7a32918242af.png)
|**ResultSet rs = ps.executeQuery()**|
||
||
|To set **?** in sql statement as a certain value|
|ps.setString(1, **state**);|

## Development
 
#### 1. Create Maven Project 

**Maven** is a powerful project management tool that is based on POM (project object model). It is used for projects build, dependency and documentation.  

#### 2. Add dependency in .xml file, (don't forget to right click, Maven-update maven project)

`
<dependencies> <dependency> <groupId>mysql</groupId> <artifactId>mysql-connector-java</artifactId> <version>5.1.45</version> </dependency> <dependency> <groupId>junit</groupId> <artifactId>junit</artifactId> <version>3.8.1</version> <scope>test</scope> </dependency> </dependencies> 
`

#### 3. Add external jar file to module path 

mysql-connector-java-8.0.20.jar

#### 4. Check URL for database connection 

dburl = "jdbc:mysql://localhost:3306/us_governors" 

#### 5. Check class name for Loading Driver 

Class.forName("com.mysql.**cj**.jdbc.Driver"); 

Don't use Class.forName("com.mysql.jdbc.Driver"); deprecated!! 
![image](https://user-images.githubusercontent.com/55266110/131237275-19ee08da-1b1d-4f89-a953-ca508e53371b.png)

## Data (.sql) 
https://github.com/CivilServiceUSA/us-governors/tree/master/us-governors/data
