public class LinearEquation {
    private double x1, y1, x2, y2;


    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public String points() {
        return "The 2 points are (" + (int) x1 + ", " + (int) y1 + ") and (" + (int) x2 + ", " + (int) y2 + ")";
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }


    public double slope() {
        return roundedToHundredth((y2 - y1) / (x2 - x1));
    }


    public double yIntercept() {
        return roundedToHundredth(y1 - slope() * x1);
    }


    public String equation() {
        int rise = (int) (y2 - y1);
        int run = (int) (x2 - x1);
        String slope = (rise + "/" + run);
        double yIntercept = yIntercept();
        if (rise == 0) {
            return ("y = " + yIntercept);
        }
        return ("y = " + slope + "x + " + yIntercept);
    }


    public String coordinateForX(double x) {
        return ("(" + x + ", " + (slope() * x + yIntercept()) + ")");
    }


    public String lineInfo() {
        if (x1 == x2) {
            return "These points are on a vertical line, x = " + x1;
        }
        return (points() + "\nEquation: " + equation() + "\nY-Intercept: " + yIntercept()  + "\nSlope: " + slope() + "\nDistance: " + distance());
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }

    public boolean vert() {
        if (x1 == x2) {
            return true;
        } else return false;
    }
}



