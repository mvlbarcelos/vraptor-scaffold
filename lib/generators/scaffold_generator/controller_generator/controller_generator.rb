class ControllerGenerator < BaseScaffold
  
  def self.source_root
    File.dirname(__FILE__)
  end
  
  def build
    template("templates/controller.erb", "src/main/java/app/controllers/#{controller_class_name}.java")
    template("templates/controller_test.erb", "src/test/java/app/controllers/#{controller_class_name}Test.java")
  end
  
  def controller_class_name
    "#{class_name}Controller"
  end
  
  def path
    "/#{@model.pluralize}"
  end
end
