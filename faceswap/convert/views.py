from django.http import HttpResponse, FileResponse
from django.shortcuts import render
from faceswap.faceswap import main as fswap
from .forms import SynthesisForm
from django.views.decorators.csrf import csrf_exempt

# Create your views here.
@csrf_exempt
def convert(request):
    if request.method == 'POST':
        # print(request.FILES['input_image'])
        try:
            # 1 Select image for style -> from frontend 
            # 2 Synthesis image
            input_img_array = bytearray(request.FILES['input_image'].read())
            style_img_array = bytearray(request.FILES['style_image'].read())

            output_image_base64 = fswap(style_img_array, input_img_array)
            # 3 return output image
            return HttpResponse(output_image_base64, content_type="image/jpg")
        except:
            return HttpResponse(status=500)
    else:
        pass
    return HttpResponse(status=405)