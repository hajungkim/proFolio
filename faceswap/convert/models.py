from django.db import models

# Create your models here.
class Synthesis(models.Model):
    input_image = models.ImageField(upload_to='images/')
    style_image = models.ImageField(upload_to='images/')
    