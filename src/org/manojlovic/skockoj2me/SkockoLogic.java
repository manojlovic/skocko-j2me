package org.manojlovic.skockoj2me;

/**
 *
 * @author Manojlović Miloš (manojlovic88@gmail.com)
 */

public class SkockoLogic {
    private int[] result = new int[4];
    private int[] tmp_result = new int[4];
    private int[] check_res = new int[4];
    private int[] res_img = new int[4];
    
    private int redCircles = 0;
    private int yellowCircls = 0;
    
    /**
     * Constructor - 6 random numbers - range 1-6
     */
    public SkockoLogic(int[] res) {
        this.result[0] = res[0];
        this.result[1] = res[1];
        this.result[2] = res[2];
        this.result[3] = res[3];
        
    }
    
    public int[] getResult(){
        return this.result;
    }
    
    /**
     * check result
     */
    public int[] chechResult(int[] res){
        this.check_res[0] = res[0];
        this.check_res[1] = res[1];
        this.check_res[2] = res[2];
        this.check_res[3] = res[3];
        
        this.tmp_result[0] = this.result[0];
        this.tmp_result[1] = this.result[1];
        this.tmp_result[2] = this.result[2];
        this.tmp_result[3] = this.result[3];
        
        this.redCircles = 0;
        this.yellowCircls = 0;
        
        checkRedCircles();
        checkYellowCircls();
        
        fillResImg();
        
        return this.res_img;
    }
    
    private void checkRedCircles(){
        for(int i=0; i<4; i++){
            if(this.tmp_result[i] == this.check_res[i]){
                this.redCircles++;
                // priper for yellow circls checking
                this.tmp_result[i] = 10;
                this.check_res[i] = 10;
            }
        }
    }
    
    private void checkYellowCircls(){
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(this.tmp_result[i]<10 && this.check_res[j]<10){
                    if(this.tmp_result[i] == this.check_res[j]){
                        this.yellowCircls++;
                        // 
                        this.tmp_result[i] = 10;
                        this.check_res[j] = 10;
                    }
                }
            }
        }
    }
    
    private void fillResImg(){
        for(int i=0; i<4; i++){
            if(this.redCircles > 0){
                this.res_img[i] = 8; // 8 is red circl image
                this.redCircles--;
            }else if(this.yellowCircls > 0){
                this.res_img[i] = 9; // 9 is yellow circl image
                this.yellowCircls--;
            }else{
                this.res_img[i] = 7; // 7 is white circl image
            }
        }
    }
    
}
