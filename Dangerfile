# Importar la dependencia para utilizar GitHub
import 'danger/danger'

# Obtener el nombre de usuario del autor del PR
author_username = github.pr_author

# Obtener las dependencias desactualizadas del archivo Gemfile.lock
outdated_gems = Bundler.outdated

# Obtener la lista de revisores aprobados
approved_reviewers = github.pr_reviewers.approved.map(&:username)

# Verificar si "Endika" ha aprobado el PR
if !approved_reviewers.include?('uesl4a')
  warn("Este PR no ha sido aprobado por 'Endika'. Por favor, asegúrate de que 'Endika' apruebe el PR antes de fusionarlo.")
end

# Verificar si hay dependencias desactualizadas
if outdated_gems.any?
  warn("Se han encontrado #{outdated_gems.count} dependencias desactualizadas. Por favor, considera actualizarlas.")
end

# Ejecutar el comando 'bundle audit' para verificar la seguridad de las dependencias
bundle_audit_result = `bundle-audit check`

# Verificar si hay problemas de seguridad críticos
if $?.success?
  warn("Se han encontrado problemas de seguridad en las dependencias. Por favor, revisa el informe de seguridad para más detalles.")
end
