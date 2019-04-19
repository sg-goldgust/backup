/**
 * 
 */

function Student(name) {
	if(!(this instanceof Student)) {
		return new Student(name);
		//변환 함수로 작동
	}
	this.name = name;
}

var student = new Student('Java');
var student2 = Student('JavaScript');

Student.prototype.toString = function(){
	return `${this.name}`;
}

console.log(student.toString());