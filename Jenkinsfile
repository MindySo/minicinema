pipeline{
	agent any; 
	stages {
		stage('Test') { 
			steps { 
				echo 'It works!' 
			}
		}
			
		stage('build') {
			steps {
				sh 'gradle --version'
			}
		}
	}
}