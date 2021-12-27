package tag17;

public class Tag17 {
    private static final int X_MIN = 185;
    private static final int X_MAX = 221;
    private static final int Y_MIN = -122;
    private static final int Y_MAX = -74;


    public static void main(String[] args) {
        System.out.println("Part 1: " + (Y_MIN * (Y_MIN + 1)) / 2);
        int steps = Math.max(X_MAX, -Y_MIN*3);
        int cnt = 0;
        for (int x = 1; x <= X_MAX ; x++) {
            for (int y = Y_MIN; y <= -Y_MIN; y++) {
              Probe p = new Probe(x, y);
              if (hitsTarget(p, steps)){
                  cnt++;
              }
            }
        }
        System.out.println(cnt);
        /*int steps = getSteps(new Probe(0, 121));
        for (int i = 1; i < X_MAX; i++) {
            Probe newProbe = new Probe(i, 0);
            if(getSteps2(newProbe, steps)){
                System.out.println(i);
                System.out.println(newProbe);
            }
        }
        Probe p = new Probe(19, 121);
        System.out.println(getSteps(p));*/
    }

    private static boolean hitsTarget(Probe probe, int steps){
        for (int i = 0; i < steps; i++) {
            step(probe);
            if (probe.getX() <= X_MAX && probe.getX()>= X_MIN && probe.getY() <= Y_MAX && probe.getY() >= Y_MIN){
                return true;
            }
        }
        return false;
    }

    private static int getSteps(Probe probe) {
        int stepCnt = 0;
        System.out.println(probe);
        while (probe.getY() >= Y_MIN) {
            step(probe);
            System.out.println(probe);
            stepCnt++;
        }
        System.out.println("Step-Count: " + --stepCnt);
        return stepCnt;
    }

    private static boolean getSteps2(Probe probe, int stepCount) {
        for (int i = 0; i < stepCount; i++) {
            step(probe);
        }
        if (probe.getX() >= X_MIN && probe.getX() <= X_MAX) {
            return true;
        }
        return false;
    }

    private static void step(Probe probe) {
        probe.setX(probe.getX() + probe.getXVelocity());
        probe.setY(probe.getY() + probe.getYVelocity());
        if (probe.getXVelocity() > 0) {
            probe.setXVelocity(probe.getXVelocity() - 1);
        } else if (probe.getXVelocity() < 0) {
            probe.setXVelocity(probe.getXVelocity() + 1);
        }
        probe.setYVelocity(probe.getYVelocity() - 1);
    }


    private static class Probe {
        int x;
        int y;
        int xVelocity;
        int yVelocity;

        public Probe(int xVelocity, int yVelocity) {
            this.xVelocity = xVelocity;
            this.yVelocity = yVelocity;
            this.x = 0;
            this.y = 0;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getXVelocity() {
            return this.xVelocity;
        }

        public int getYVelocity() {
            return this.yVelocity;
        }

        public void setXVelocity(int xVelocity) {
            this.xVelocity = xVelocity;
        }

        public void setYVelocity(int yVelocity) {
            this.yVelocity = yVelocity;
        }

        @Override
        public String toString() {
            return "Probe{" +
                    "Position={" + x +
                    ", " + y +
                    "}; Velocity={" + xVelocity +
                    ", " + yVelocity +
                    "}}";
        }
    }
}
