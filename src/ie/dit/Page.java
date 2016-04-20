package ie.dit;

import java.util.ArrayList;

public class Page {

    int pageno;
    int nooflines;
    ArrayList<String> lines;

    Page( int pagenumber){
        nooflines = 28;
        lines = new ArrayList<>();
        pageno = pagenumber;
    }

}

