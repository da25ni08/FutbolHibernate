package src.futbolhibernate;


import org.hibernate.Session;
import org.hibernate.query.Query;
import src.futbolhibernate.model.Matchs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static String direccionSQL() {
        return "jdbc:mysql://localhost:3306/";
    }

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(direccionSQL(), usuarioSQL(), passwordSQL());
    }

    public static String usuarioSQL() {
        return "root";
    }

    public static String passwordSQL() {
        return "";
    }

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            //Devolver todos los partidos que se hayan jugado en alguna liga de España.
            Query<Matchs> queryMatch = session.createQuery("FROM Matchs as m inner join divisions as d where d.country = :country", Matchs.class);
            queryMatch.setParameter("country", "Spain");
            List<Matchs> matchsSpain = queryMatch.getResultList();

            for (Matchs matchs : matchsSpain){
                System.out.println(matchs.toString());
            }

            //Devolver todos los partidos donde el visitante haya ganado por goleada (es decir, por 3 o más goles).
            queryMatch = session.createQuery("FROM Matchs where FRT = :winner and (FTAG - FTHG) >= 3", Matchs.class);
            queryMatch.setParameter("winner", "A");
            List<Matchs> matchesMore3Goals = queryMatch.getResultList();

            for (Matchs matchs : matchesMore3Goals){
                System.out.println(matchs.toString());
            }

            //Devolver el máximo de goles del equipo visitante (diap 54 y 55). El máximo es 13
            Query<Double> queryMaxGoals  = session.createQuery("SELECT max(FTAG) FROM Matchs", Double.class);
            double maxGoals = queryMaxGoals.getSingleResult();
            System.out.println("Maximo de goles:  " + maxGoals );

            //Devolver cada equipo (usad el local) con el número de veces que aparece por temporada. (diap 56).
            Query<Object[]> queryNumVecesEquipo = session.createQuery("SELECT homeTeam, year(match_date) as year, count(*) FROM Matchs group by homeTeam, year", Object[].class);
            List<Object[]> numVecesEquipo = queryNumVecesEquipo.getResultList();

            for(Object[] numVeces : numVecesEquipo){
                System.out.println(numVeces[0] + " || " + numVeces[1] + " || " + numVeces[2] );
            }



        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }



    }
}