import java.sql.*;

/**
 * Created by Ramazan on 20.03.2017.
 */
public class SQLHelper {
    private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static LearningSet getData(){
        Connection conn = null;
        LearningSet trainingDataSet = new LearningSet();
        try{
            Class.forName(driver).newInstance();
            String dbURL = "jdbc:sqlserver://localhost;databaseName=LearningSet;integratedSecurity=true;";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                PlayStatistics playStatistics = null;
                Statement statement = conn.createStatement();
                String query = "select * from Category";
                ResultSet resultSet = statement.executeQuery(query);
                /*ResultSetMetaData resultSetMetaData = resultSet.getMetaData();*/


                int columnCount = resultSet.getMetaData().getColumnCount();

                int iterator = 1;
                while (resultSet.next()) {
                    Record record = new Record();
                    for (int i = 1; i <= columnCount; i++ ) {
                        String atributeName = resultSet.getMetaData().getColumnName(i).trim();
                        String atributeValue = resultSet.getString(iterator++).trim();
                        record.atributes.add(new Atribute(atributeName, atributeValue));
                    }
                    trainingDataSet.records.add(record);
                    iterator=1;
                }
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        trainingDataSet.performAtributeMapping();
        return trainingDataSet;
    }
}
