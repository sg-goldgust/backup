import os
from PIL import Image
import numpy as np
# 이미지 데이터를 1차원 배열로 변화
# 각 데이터는 0.0 ~ 1.0의 값을 가짐
def img_to_arr(file_path):
    im = Image.open(file_path)
    arr = np.array(im).flatten()
    return arr/255
    
target_dir = 'C:/python/images/'
list = os.listdir(target_dir) # 상위 디렉토리 순회

for dir in list :
    work_dir = os.path.join(target_dir,dir)
    arr_list = [] # 디렉토리에 있는 이미지 배열 리스트

    for file in os.listdir(work_dir) : # 하위 디렉토리 순회
        file_path = os.path.join(work_dir, file)
        _, ext = os.path.splitext(file_path)

        if ext != '.ppm': continue # 이미지 파일이 아닌 경우 체크

        arr = img_to_arr(file_path) # 이미지 파일인 경우 배열로 변환
        arr_list.append(arr) # 이미지 배열을 리스트에 추가
        
    # 이미지 배열 리스트를 csv 파일로 저장
    dest = os.path.join(work_dir, dir+".csv")
    np.savetxt(dest, arr_list, fmt='%.6f', delimiter=',')
    print(dest)