package ie.dit;

/**
 * Created by Vardaan on 4/18/2016.
 */
public class Page {

    int pageno;
    int nooflines;
    String[] lines;

    Page( int pagenumber){
        nooflines = 28;
        lines = new String[nooflines];
        pageno = pagenumber;
    }

}

