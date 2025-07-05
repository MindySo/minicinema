pipeline{
	agent{docker{image 'gradle:8.5-jdk17'}}
	stages('build' ){
		steps{
			sh 'mvn --version'
		}
	}
}