class NBody {
    public static double readRadius(String path) {
        In in = new In(path);
        int number = in.readInt();
        double radius = in.readDouble();
        return radius;
    }
    public static Planet[] readPlanets(String path){
        In in = new In(path);
        in.readInt();
        in.readDouble();
        Planet[] plist = new Planet[5]; //using new to define a new object
        for(int i = 0; i < 5; ++i){
             plist[i] = new Planet(in.readDouble(),  in.readDouble(),  in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return plist;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String path = args[2];
        double radius = readRadius(path);
        Planet[] plist = readPlanets(path);
        String img = "./images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, img);
        for(Planet p: plist){
           p.draw();
        }
        StdDraw.enableDoubleBuffering();
        for(double t = 0; t <= T;){
            double[] xForces = new double[plist.length];
            double[] yForces = new double[plist.length];
            for(int i = 0; i < plist.length; ++i){
                xForces[i] = plist[i].calcNetForceExertedByX(plist);
                yForces[i] = plist[i].calcNetForceExertedByY(plist);
            }
            for(int i = 0; i < plist.length; ++i){
                plist[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, img);
            for(Planet p: plist){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t = t + dt;
        }
        StdOut.printf("%d\n", plist.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < plist.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    plist[i].xxPos, plist[i].yyPos, plist[i].xxVel,
                    plist[i].yyVel, plist[i].mass, plist[i].imgFileName);
        }
    }
}