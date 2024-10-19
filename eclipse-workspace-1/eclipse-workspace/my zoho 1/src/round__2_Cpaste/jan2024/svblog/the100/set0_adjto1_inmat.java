package round__2_Cpaste.jan2024.svblog.the100;
//Given a Boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 then make its adjacent cells as 0.


public class set0_adjto1_inmat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][]=new int[1][1];
		int n=1;
		int m=1;
for(int i=0;i<n;i++) {
	for(int j=0;j<m;j++) {
		if(i>0)mat[i-1][j]=0;
		if(j>0)mat[i][j-1]=0;
		if(i<n)mat[i+1][j]=0;
		if(j<m)mat[i][j+1]=0;
		
		
	}
}
	}

}
