class Planet {
    public static double G = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p){
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double distance = Math.sqrt(dx*dx + dy*dy);
        return distance;
    }
    public boolean equals(Planet p) {
        if (this.xxPos == p.xxPos && this.yyPos == p.yyPos && this.mass == p.mass) {
            return true;
        }
        return false;
    }

    public double calcForceExertedBy(Planet p){
        if (this.equals(p)) {
            return 0;
        }
        return G * this.mass * p.mass / Math.pow(this.calcDistance(p), 2);
    }

    public double calcForceExertedByX(Planet p){
        if (this.equals(p)) {
            return 0;
        }
        return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);

    }

    public double calcForceExertedByY(Planet p){
        if (this.equals(p)) {
            return 0;
        }
        return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] plist) {
        double sum = 0;
        for(Planet p : plist) {
            if (this.equals(p)) {
                continue;
            }
            sum += calcForceExertedByX(p);
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] plist) {
        double sum = 0;
        for(Planet p : plist) {
            if (this.equals(p)) {
               continue;
            }
            sum += calcForceExertedByY(p);
        }
        return sum;
    }
    public double calcAcce(double f){
        return f / this.mass;
    }
    public void update(double dt, double fx, double fy) {
        this.xxVel += calcAcce(fx) * dt;
        this.yyVel += calcAcce(fy) * dt;
        this.xxPos += xxVel * dt;
        this.yyPos += yyVel * dt;
    }
    public void draw() {
        String img = this.imgFileName;
        StdDraw.picture(this.xxPos * 1e-9, this.yyPos * 1e-9, "./images/" + img);
    }
}