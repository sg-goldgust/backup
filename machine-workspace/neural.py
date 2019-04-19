import numpy 
from scipy.special import expit
import pandas as pd

class neuralNetwork:


    def __init__(self, inputnodes, hiddennodes, outputnodes, learningrate):
        self.inodes = inputnodes
        self.hnodes = hiddennodes
        self.onodes = outputnodes

        self.lr = learningrate
        
        self.wih = numpy.random.normal(0.0, pow(self.hnodes,-0.5), (self.hnodes,self.inodes))
        self.who = numpy.random.normal(0.0, pow(self.onodes,-0.5), (self.onodes,self.hnodes))

        self.activation_function = lambda x : expit(x)
        
    def load(self, path):
        data_frame = pd.read_csv(path,header=None)
        values = data_frame.values
        labels = values[:,0:1]
        data = values[:,1:]/255.0*0.99 + 0.01
        return labels,data

    def train(self, inputs_list, targets_list):
        inputs = numpy.array(inputs_list,ndmin=2).T
        targets = numpy.array(targets_list,ndmin=2).T
      
        hidden_inputs = numpy.dot(self.wih,inputs)
        hidden_outputs = self.activation_function(hidden_inputs)

        final_inputs = numpy.dot(self.who,hidden_outputs)
        final_outputs = self.activation_function(final_inputs)

        #오차 배열
        output_errors = targets - final_outputs
        hidden_errors = numpy.dot(self.who.T,output_errors)

        #가중치 업데이트를 위한 활성함수
        self.who += self.lr * numpy.dot(
            (output_errors*final_outputs*(1.0-final_outputs)),
            numpy.transpose(hidden_outputs))

        self.wih += self.lr * numpy.dot(
            (hidden_errors*hidden_outputs*(1.0-hidden_outputs)),
            numpy.transpose(inputs))
     
    def train_from_file(self,path):
        for label,inputs in zip(*self.load(path)):
            targets = numpy.zeros(self.onodes) + 0.01
            targets[label] = 0.99
            self.train(inputs,targets)

    def query(self,inputs_list):
        inputs = numpy.array(inputs_list,ndmin=2).T

        hidden_inputs = numpy.dot(self.wih,inputs)
        hidden_outputs = self.activation_function(hidden_inputs)

        final_inputs = numpy.dot(self.who,hidden_outputs)
        final_outputs = self.activation_function(final_inputs)
        return final_outputs

    def query_from_file(self,path) :
        scorecard = []
        for label, inputs in zip(*self.load(path)):
          
            outputs = self.query(inputs)
            # 가장 높은 값의 인덱스는 레이블의 인덱스와 일치해야 함 
            answer = numpy.argmax(outputs) 
           
            # 정답 여부 판단 
            if(label == answer): 
                # 정답인 경우 성적표에 1을 추가
                scorecard.append(1) 
            
            else: 
                # 정답이 아닌 경우 성적표에 0을 추가 
                scorecard.append(0) 
                
        scorecard_array = numpy.asarray(scorecard)
        return scorecard_array.sum()/scorecard_array.size

    def load_weight(self,path) :
        self.wih = pd.read_csv(path + "_wih.csv", header=None)
        self.who = pd.read_csv(path + "_who.csv", header=None)
    
    def save_weight(self,path) :
        pd.DataFrame(self.wih).to_csv(path + "wih.csv", index=False, header=None)
        pd.DataFrame(self.who).to_csv(path + "_who.csv", index=False, header=None)